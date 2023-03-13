package pw.se2.tdd;

public class StringCalculator {
    public int calculate (String arg) throws Exception{
        int sum = 0;
        if (arg.equals(""))
            sum = 0;
        else if (arg.indexOf("-")!=-1) {
            throw new Exception("Negatives are not allowed!");
        } else {
            String regex = ",|\n";
            if(arg.indexOf("//")!=-1){
                regex+=("|"+arg.charAt(2));
                arg = arg.substring(3);
            }
            String[] elements = arg.split(regex);
            for(int i = 0; i < elements.length; i++)
                if(Integer.parseInt(elements[i]) < 1000)
                    sum += Integer.parseInt(elements[i]);
        }
        return sum;
    }
}
