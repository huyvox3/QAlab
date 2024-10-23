public class AverageCalculator {
    public int average(int value[], int minnum, int maxnum) {
        int i = 0;
        int inputNumber = 0;
        int validNumber = 0;
        int sum=0;

        while ((value[i] != -999) && (inputNumber <100)){
            inputNumber++;
            if ((value[i] >= minnum) && (value[i] <= maxnum)){
                validNumber++;
                sum += value[i];
            }
            else continue;
            i++;
        }
        if (validNumber > 0){
            return sum/ validNumber;
        }
        return -999;
    }
}
