public class centralMovement {
    public static void main(String[] args) {
        double x[] = {1,2,3,4,5,6,7,8,9,10};
        double f[] = {218.2,199.7,207.3,185.4,213.7,184.7,179.5,194.4,224.3,203.5};
        centralMovementProcedure(x, f); 
    }

    public static void centralMovementProcedure(double[] x, double[] f){
        
        double xf[] = new double[x.length];
        double sumXF = 0;
        double sumF = 0;
        for (int i = 0; i < x.length; i++) {
            xf[i] = x[i] * f[i];
            sumXF = sumXF + xf[i];
            sumF = sumF + f[i];
        }
        
        double mean = sumXF/sumF;
        double assumedMean[] = new double[x.length];
        double firstMovement[] = new double[x.length];
        double secondMovement[] = new double[x.length];
        double thirdMovement[] = new double[x.length];
        double fourthMovement[] = new double[x.length];

        for (int i = 0; i < x.length; i++) {
            assumedMean[i] = x[i]-mean;
        }
        for (int i = 0; i < x.length; i++) {
            firstMovement[i] = f[i]*(int)Math.pow(assumedMean[i], 1);
            secondMovement[i] = f[i]*(int)Math.pow(assumedMean[i], 2);
            thirdMovement[i] = f[i]*(int)Math.pow(assumedMean[i], 3);
            fourthMovement[i] = f[i]*(int)Math.pow(assumedMean[i], 4);
        }

        double sumFirstMovement = 0;
        double sumSecondMovement = 0;
        double sumThirdMovement = 0;
        double sumFourthMovement = 0;
        for (int i = 0; i < x.length; i++) {
            sumFirstMovement = sumFirstMovement + firstMovement[i];
            sumSecondMovement = sumSecondMovement + secondMovement[i];
            sumThirdMovement = sumThirdMovement + thirdMovement[i];
            sumFourthMovement = sumFourthMovement + fourthMovement[i];
        }

        double mu1 = sumFirstMovement/sumF;
        double mu2 = sumSecondMovement/sumF;
        double mu3 = sumThirdMovement/sumF;
        double mu4 = sumFourthMovement/sumF;

        System.out.println("N: "+sumF);
        System.out.println("XF: "+sumXF);
        System.out.println("Mean: " + mean);
        System.out.println("mu1: "+mu1);
        System.out.println("mu2: "+mu2);
        System.out.println("mu3: "+mu3);
        System.out.println("mu4: "+mu4);

    }
}