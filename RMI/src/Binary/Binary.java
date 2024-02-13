package Binary;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Binary extends UnicastRemoteObject implements ITwosComplement {

    public Binary() throws RemoteException {
        super();
    }

    ;
    
    @Override
    public int[] decimalToBinary(int number) throws RemoteException {

        int[] binary = new int[32];
        int id = 0;

        while (number > 0) {
            binary[id++] = number % 2;
            number = number / 2;
        }

        int[] correctBinary = reverseList(binary);

        return correctBinary;
    }

    @Override
    public int[] binaryToTwosComplement(int[] binary) throws RemoteException {
        try {
            int[] binaryInvert = invertBits(binary); // se é 1 vira 0, se é 0 vira 1
            int[] binaryResult = sumOne(binaryInvert);
            return binaryResult;
        } catch (RemoteException ex){
            throw new RemoteException(ex.getMessage());
        } catch(Exception ex){
            throw new RemoteException(ex.getMessage());
        }
    }

    @Override
    public void printBinaryNumber(int[] number) throws RemoteException {
        for (int index : number) {
            System.out.print(index + "");
        }

        System.out.println("");
    }

    private int[] sumOne(int binaryInvert[]) {
        int binaryLength = binaryInvert.length - 1;

        int lastBit = binaryInvert[binaryLength];

        boolean lastBitIsEqualsZero = lastBit == 0;

        if (lastBitIsEqualsZero) {
            binaryInvert[binaryLength] += 1; // Se o ultimo bit é 0, então ele simplismente vira 1. Ex: 0100 -> 0101
            return binaryInvert;
        }

        // Se caiu aqui, o bit menos significativo é 1, logo 1 + 1 = 0 e "vai um" pra soma do bit da esquerda
        boolean addOne = true;
        int indexLastBit = binaryLength;

        while (addOne && indexLastBit != 0) {

            binaryInvert[indexLastBit] += 1; // Sempre some um no ultimo bit

            if (binaryInvert[indexLastBit] == 2) { // 1 + 1 = 2, logo, o bit vira 0. E "VAI UM" pro bit da esquerda
                binaryInvert[indexLastBit] = 0;
                addOne = true;
            } else {
                addOne = false;
            }

            indexLastBit--; // Indice do ultimo bit desloca p/ esquerda
        }

        return binaryInvert;
    }

    private int[] invertBits(int[] binary) throws Exception {
        int binaryLength = binary.length;

        for (int index = 0; index < binaryLength; index++) {
            switch (binary[index]) {
                case 0:
                    binary[index] = 1;
                    break;
                case 1:
                    binary[index] = 0;
                    break;
                default:
                    throw new Exception("Erro: Number is not binary!");
            }
        }

        return binary;
    }

    private int[] reverseList(int[] number) {

        int length = number.length;

        int[] listAux = new int[length];

        int count = 0;
        for (int lastIndex = length - 1; lastIndex >= 0; lastIndex--) {
            
            listAux[count] = number[lastIndex];
            count++;
        
        }

        return listAux;

    }
}
