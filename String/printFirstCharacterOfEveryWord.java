public class Demo {
    static void printFirstCharacterOfEveryWordWithoutUsingSplit(String str){
        char[] arr = str.toCharArray();
        boolean space_found = false;
        for (int i=0; i< arr.length; i++){
            if (arr[i] == ' '){
                space_found = true;
            } else {
                if (space_found == true || i==0){
                    System.out.print(arr[i] + " ");
                    space_found = false;
                }
            }
        }
    }

    static void printFirstCharacterOfEveryWordUsingSplit(String str){
        String[] arr = str.split("\\s+");
        for (int i=0; i<arr.length; i++){
            //To not consider blank strings that split generates for leading & training spaces.
            if (arr.length > 0)
                System.out.print(arr[i].charAt(0) + " ");
        }
    }

    public static void main(String[] args){
        String str = "Pawan Kishor Singh";
        printFirstCharacterOfEveryWordUsingSplit(str); //P K S
        System.out.println();
        printFirstCharacterOfEveryWordWithoutUsingSplit(str); //P K S
    }
}
