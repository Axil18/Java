package Hw_2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class bubbleSort {
    private static final Logger LOGGER = Logger.getLogger(bubbleSort.class.getName());

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 12, 1, 9};
        LOGGER.setLevel(Level.INFO);

        try {
            FileHandler fileHandler = new FileHandler("bubble_sort.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при настройке файла журнала.", e);
        }

        LOGGER.info("Исходный массив: " + Arrays.toString(array));

        bubbleSort(array);

        LOGGER.info("Отсортированный массив: " + Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            LOGGER.info("Итерация " + (i + 1) + ": " + Arrays.toString(array));

            if (!swapped) {
                break;
            }
        }
    }
}