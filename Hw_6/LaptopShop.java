package Hw_6;

import java.util.*;

public class LaptopShop {
    public static void main(String[] args) {
        
        Set<Laptop> laptops = createLaptops();

        Map<String, String> filterCriteria = getFilterCriteria();

        Set<Laptop> filteredLaptops = filterLaptops(laptops, filterCriteria);
        displayLaptops(filteredLaptops);
    }

    public static Set<Laptop> createLaptops() {
        Set<Laptop> laptops = new HashSet<>();

        laptops.add(new Laptop("Dell", 8, 512, "Windows", "Silver"));
        laptops.add(new Laptop("HP", 16, 256, "Windows", "Black"));
        laptops.add(new Laptop("Apple", 16, 512, "MacOS", "Space Gray"));
        laptops.add(new Laptop("Lenovo", 8, 1, "Windows", "Black"));

        return laptops;
    }

    public static Map<String, String> getFilterCriteria() {
        Map<String, String> filterCriteria = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цифру, соответствующую критерию фильтрации:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int criterion = scanner.nextInt();

        switch (criterion) {
            case 1:
                System.out.println("Введите минимальное значение ОЗУ:");
                int minRam = scanner.nextInt();
                filterCriteria.put("ram", String.valueOf(minRam));
                break;
            case 2:
                System.out.println("Введите минимальный объем ЖД (в ГБ):");
                int minStorage = scanner.nextInt();
                filterCriteria.put("storage", String.valueOf(minStorage));
                break;
            case 3:
                System.out.println("Введите требуемую операционную систему:");
                scanner.nextLine();
                String os = scanner.nextLine();
                filterCriteria.put("os", os);
                break;
            case 4:
                System.out.println("Введите требуемый цвет:");
                scanner.nextLine();
                String color = scanner.nextLine();
                filterCriteria.put("color", color);
                break;
            default:
                System.out.println("Некорректный критерий фильтрации.");
                break;
        }

        scanner.close();

        return filterCriteria;
    }

    public static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, String> filterCriteria) {
        Set<Laptop> filteredLaptops = new HashSet<>();

        for (Laptop laptop : laptops) {
            boolean meetsCriteria = true;

            for (Map.Entry<String, String> entry : filterCriteria.entrySet()) {
                String criterion = entry.getKey();
                String value = entry.getValue();

                if (!laptop.meetsCriterion(criterion, value)) {
                    meetsCriteria = false;
                    break;
                }
            }

            if (meetsCriteria) {
                filteredLaptops.add(laptop);
            }
        }

        return filteredLaptops;
    }

    public static void displayLaptops(Set<Laptop> laptops) {
        System.out.println("Результаты фильтрации:");

        if (laptops.isEmpty()) {
            System.out.println("Ноутбуки, отвечающие условиям фильтрации, не найдены.");
        } else {
            for (Laptop laptop : laptops) {
                System.out.println(laptop);
            }
        }
    }
}

class Laptop {
    private String brand;
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Laptop(String brand, int ram, int storage, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public boolean meetsCriterion(String criterion, String value) {
        switch (criterion) {
            case "ram":
                return ram >= Integer.parseInt(value);
            case "storage":
                return storage >= Integer.parseInt(value);
            case "os":
                return os.equalsIgnoreCase(value);
            case "color":
                return color.equalsIgnoreCase(value);
            default:
                return false;
        }
    }

    @Override
   public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}