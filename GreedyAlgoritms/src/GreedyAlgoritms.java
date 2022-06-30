public class GreedyAlgoritms {
    // Жадные алгоритмы
    // Составление маршрута с минимальным количеством остановок на заправку
    public static void main(String[] args) {
        int milesOnFullTank = 400; // Миль на полном баке
        // Маршрутные точки
        int[] stations = {0, 190, 375, 550, 760, 950};
        System.out.println(minimalStops(stations, milesOnFullTank));
    }

    public static int minimalStops(int[] stations, int capacity) {
        int result = 0;
        int currentStop = 0;

        while(currentStop < stations.length-1) {
            int nextStop = currentStop;
            while(nextStop < stations.length-1 && stations[nextStop+1]-stations[currentStop] <= capacity) {
                nextStop++;
            }
            if(nextStop == currentStop) { // Некуда ехать
                result = -1;
                break;
            }
            if(nextStop < stations.length-1)
                result++;
            currentStop = nextStop;
            System.out.println("Result: "+result+" currStop: "+currentStop);
        }
        return result;
    }
}
