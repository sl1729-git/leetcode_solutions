package Solution500_;

public class Solution649 {
    private String solution(String senate){
        char[] senates = senate.toCharArray();
        int[] nextSenate = new int[senates.length];
        int RCount = 0, DCount = 0;
        for (int i = 0; i < nextSenate.length; i++) {
            nextSenate[i] = i+1;
            RCount += senates[i] == 'R' ? 1 : 0;
            DCount += senates[i] == 'D' ? 1 : 0;
        }
        nextSenate[nextSenate.length-1] = 0;
        int index = 0, tmp = 0;
        char currentSenate = '0', removeSenate = '0';
        while (true){
            if (RCount == 0)
                return "Dire";
            if (DCount == 0)
                return "Radiant";
            currentSenate = senates[index];
            removeSenate = currentSenate == 'R' ? 'D' : 'R';
            tmp = index;
            while (senates[nextSenate[tmp]] != removeSenate){
                tmp = nextSenate[tmp];
            }
            nextSenate[tmp] = nextSenate[nextSenate[tmp]];
            RCount -= removeSenate == 'R' ? 1 : 0;
            DCount -= removeSenate == 'D' ? 1 : 0;
            index = nextSenate[index];
        }
    }

    public String predictPartyVictory(String senate) {
        return solution(senate);
    }

    public static void main(String[] args) {
        Solution649 s = new Solution649();
        System.out.println(s.predictPartyVictory("DRRDRDRDRDDRDRDR"));
    }
//        boolean[] canVote = new boolean[senate.length()];
//        char[] senates = senate.toCharArray();
//        List<Integer> RList = new ArrayList<>();
//        List<Integer> DList = new ArrayList<>();
//        Arrays.fill(canVote, true);
//        for (int i = 0; i < senates.length; i++) {
//            if (senates[i] == 'R')
//                RList.add(i);
//            else if (senates[i] == 'D')
//                DList.add(i);
//        }
//        while (!RList.isEmpty() || !DList.isEmpty()){
//            for (int i = 0; i < senates.length; i++) {
//                if (RList.isEmpty())
//                    return "Dire";
//                if (DList.isEmpty())
//                    return "Radiant";
//                if (canVote[i]){
//                    if (senates[i] == 'R') {
//                        canVote[DList.get(0)] = false;
//                        DList.remove(0);
//                    }
//                    else if (senates[i] == 'D') {
//                        canVote[RList.get(0)] = false;
//                        RList.remove(0);
//                    }
//                }
//
//            }
//        }
//        return null;

}
