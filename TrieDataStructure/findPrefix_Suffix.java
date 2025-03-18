public class findPrefix_Suffix {
    public static void Findprefix(String str){
        for (int i = 0; i < str.length(); i++) {
            findSuffix(str.substring(0, i+1));
        }

    }
    public static void findSuffix(String str){
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.substring(i, str.length()));
        }
    }

    public static void main(String[] args) {
        String name="umair";
        Findprefix(name);
        findSuffix(name);
    }
}
