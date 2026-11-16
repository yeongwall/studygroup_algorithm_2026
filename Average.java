public class Average {
    private int[] arr = new int[10];
    private int nextIndex;

    public void put(int a) {
        if(nextIndex < 10){
            arr[nextIndex] = a;
            nextIndex++;
        }
    }
    
    public void showAll(){
        for (int i = 0; i < nextIndex; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public double getAvg(){
        int sum = 0;
        for (int i = 0; i < nextIndex; i++){
            sum += arr[i];
        }
        return (double) sum / nextIndex;
    }
    
    
    public static void main(String[] args) {
        Average avg = new Average();
        avg.put(10); // 10 저장
        avg.put(15); // 15 저장
        avg.put(100); // 100 저장
        avg.showAll(); // 저장된 모든 원소 출력
        System.out.print("평균은 " + avg.getAvg()); // 평균 출력
    }
}
