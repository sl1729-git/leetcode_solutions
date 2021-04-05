package Solution500_;

public class Solution832 {

    private void invertLine(int[] line){
        int len = line.length / 2;
        int tmp = 0;
        for (int i = 0; i < len; i++) {
            tmp = line[i];
            line[i] = line[line.length - i - 1];
            line[line.length - i - 1] = tmp;
        }
    }

    private void flipImage(int[][] image){
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                image[i][j] = image[i][j] == 0 ? 1 : 0;
            }
        }
    }

    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            invertLine(image[i]);
        }

        flipImage(image);

        return image;
    }
}
