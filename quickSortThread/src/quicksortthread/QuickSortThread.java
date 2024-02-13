package quicksortthread;

public class QuickSortThread<Type extends Comparable<Type>> extends Thread {

    private final Type[] list;
    private final int indexInit;
    private final int indexEnd;
    private final String nameThread;
    
    public QuickSortThread(Type[] list) {
        this.list = list;
        this.indexInit = 0;
        this.indexEnd = list.length - 1;
        this.nameThread = "Main";
    }
    
    private QuickSortThread(Type[] list, int indexInit, int indexEnd, String nameThread) {
        this.list = list;
        this.indexInit = indexInit;
        this.indexEnd = indexEnd;
        this.nameThread = nameThread;
    }
    

    @Override
    public void run() {
        int indexPivot;
        if (indexInit < indexEnd) {
            indexPivot = partition(list, indexInit, indexEnd);
            try {
                QuickSortThread<Type> quickSortThreadLeft = new QuickSortThread<>(list, indexInit, indexPivot - 1, "Left");
                quickSortThreadLeft.start(); // Inicia a thread que ordena o lado leftuerdo 

                QuickSortThread<Type> quickSortThreadRight = new QuickSortThread<>(list, indexPivot + 1, indexEnd, "Right");
                quickSortThreadRight.start(); // Inicia a Thread que ordena o lado righteito
               
                quickSortThreadLeft.join(); 
                quickSortThreadRight.join();
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }

        }
    }

    private <Type extends Comparable<Type>> int partition(Type[] list, int indexInit, int indexEnd) {
        
        int left, right;
        Type pivot;
        Type aux;

        left = indexInit;
        right = indexEnd;
        pivot = list[indexInit];

        while (left < right) {
            
            while (list[left].compareTo(pivot) <= 0 && left < indexEnd) {
                left++;
            }

            while (list[right].compareTo(pivot) > 0 && right > indexInit) {
                right--;
            }

            if (left < right) {
                aux = list[left];
                list[left] = list[right];
                list[right] = aux;
            }
        }

        list[indexInit] = list[right];
        list[right] = pivot;

        return right;

    }
    
    
    public void printList(String header, Type[] list){
        System.out.print(header + " ");
        System.out.print("[ ");
        for (int index = 0; index < list.length; index++) {
            System.out.print(list[index]);
            if(index + 1 != list.length) System.out.print(", ");
        }
        System.out.print(" ]\n");
    }

}
