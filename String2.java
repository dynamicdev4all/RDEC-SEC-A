public class String2 {
    public static void main(String[] args) {
        // String name = "Deepak";
        // name = name + "Sharma";
        // name.toLowerCase() 
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.capacity());
        System.out.println(sb.length());
        sb.append("Deepak                                ");
        System.out.println(sb.capacity());
        System.out.println(sb.length());

    }
}
