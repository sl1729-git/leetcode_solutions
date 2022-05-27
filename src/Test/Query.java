package Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;

public class Query {
    private Node[][] blocks;
    private String[] lines;
    private String headerLine;
    private String[] headers;
    private Map<String, Integer> header2colIndex = new HashMap<>();

    public Query(Node[][] blocks, String[] lines, String header, String[] headers, Map<String, Integer> header2colIndex) {
        this.blocks = blocks;
        this.lines = lines;
        this.headerLine = header;
        this.headers = headers;
        this.header2colIndex = header2colIndex;
    }

    public Query(String tablePath) throws FileNotFoundException {
        Reader table = new FileReader(tablePath);
        this.doConstructInMemery(table);
    }

    private void doConstructInMemery(Reader table){
        List<String> lineTemp = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(table);
            String currentLine = reader.readLine();
            if (currentLine != null) {
                this.headerLine = currentLine;
                this.headers = currentLine.replace(" ","").split(",");
                for (int i = 0; i < headers.length; i++) {
                    header2colIndex.put(headers[i], i);
                }
                header2colIndex.put("*", -1);
            }
            while ((currentLine = reader.readLine()) != null){
                lineTemp.add(currentLine);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }

        this.lines = lineTemp.toArray(new String[0]);
        this.blocks = new Node[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            blocks[i] = Node.getBlocks(lines[i], i, headers.length);
        }
    }



    private void doParamCheck(List<Condition[]> params) throws Exception{
        for (Condition[] conditions:params) {
            for (Condition condition:conditions) {
                if (!this.header2colIndex.keySet().contains(condition.column))
                    throw new Exception("do not contain column named " + condition.column);
            }
        }
    }

    private String doQuery(List<Condition[]> params){
        Set<Integer> ret = new HashSet<>();
        for (Node[] line:blocks) {
            if (doQueryInLine(params, line))
                ret.add(line[0].lineIndex);
        }

        StringBuilder builder = new StringBuilder(headerLine);
        builder.append("\r\n");
        for (Integer retLineIndex:ret) {
            builder.append(lines[retLineIndex]);
            builder.append("\r\n");
        }
        return builder.toString();
    }

    private boolean doQueryInLine(List<Condition[]> params, Node[] line){
        for (Condition[] conditions:params) {
            boolean result = true;
            for (Condition condition:conditions) {
                if (condition.column.equals("*")){
                    for (Node node:line) {
                        result |= node.query(condition);
                    }
                }else {
                    int index = header2colIndex.get(condition.column);
                    Node tmp = line[index];
                    result &= tmp.query(condition);
                }
            }

            if (result)
                return true;
        }

        return false;
    }

    public String query(String query){
        String ret;
        try {
            List<Condition[]> params = Param.getParam(query);
            doParamCheck(params);
            ret = doQuery(params);
        }catch (Exception e){
            ret = e.getMessage();
        }

        return ret;
    }

    public String getSQLQuery(List<Condition[]> params, String selectPart){
        StringBuilder ret = new StringBuilder(selectPart);
        ret.append("  ");
        String[] orConditions = new String[params.size()];
        for (int i = 0; i < params.size(); i++) {
            Condition[] conditions = params.get(i);
            String[] andConditions = new String[conditions.length];
            for (int j = 0; j < conditions.length; j++) {
                andConditions[j] = conditions[j].toSQLString();
            }
            orConditions[i] = String.join(" and ",andConditions);
        }
        ret.append(String.join(" or ", orConditions));
        ret.append(";");
        return ret.toString();
    }

    public static void main(String[] args) throws Exception {
        String tablePath = "C:/Users/sl1729/Documents/临时/table.csv";
        Query query = new Query(tablePath);
        String queryTest = "C12 == \"Value\" and C3 &= \"%Value%\"";
        System.out.println(query.query(queryTest));
        System.out.println(query.getSQLQuery(Param.getParam(queryTest), "SELECT * FROM TABLE WHERE"));
    }
}

class Node{
    String block;
    int lineIndex;

    public static Node[] getBlocks(String line, int lineIndex, int colLength){
        String[] blocks = line.split(",");
        Node[] ret = new Node[colLength];
        int len = Math.min(blocks.length, ret.length);
        for (int i = 0; i < len; i++) {
            ret[i] = new Node(blocks[i], lineIndex);
        }
        return ret;
    }

    public Node(String block, int lineIndex) {
        this.block = block;
        this.lineIndex = lineIndex;
    }

    public boolean query(Condition condition){
        switch (condition.operator){
            case "==":
                return block.equals(condition.searchText);
            case "!=":
                return !block.equals(condition.searchText);
            case "$=":
                return block.toLowerCase().equals(condition.searchText.toLowerCase());
            case "&=":
                return block.contains(condition.searchText);
        }
        return false;
    }
}