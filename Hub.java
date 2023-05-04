//Adrián Mompó Fajardo
package PaqIAdrian;

import java.util.Objects;

public class Hub {
    private static Container[][] cont = new Container[10][12];

    public static boolean pile(Container container) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (cont[i][j] != null && cont[i][j].getId() == container.getId()) {
                    cont[i][j].setWeight(container.getWeight());
                    cont[i][j].setPriority(container.getPriority());
                    cont[i][j].setOrigin(container.getOrigin());
                    cont[i][j].setDescription(container.getDescription());
                    cont[i][j].setSender(container.getSender());
                    cont[i][j].setReceiver(container.getReceiver());
                    cont[i][j].setInspected(container.isInspected());
                    return true;
                }
            }
        }

        switch (container.getPriority()) {
            case 1:
                for (int i = 0; i < 10; i++) {
                    if (cont[i][0] == null) {
                        cont[i][0] = container;
                        return true;
                    }
                }
                break;
            case 2:
                for (int i = 0; i < 10; i++) {
                    if (cont[i][1] == null) {
                        cont[i][1] = container;
                        return true;
                    }
                }
                break;
            case 3:
                for (int i = 0; i < 10; i++) {
                    for (int j = 2; j < 12; j++) {
                        if (cont[i][j] == null) {
                            cont[i][j] = container;
                            return true;
                        }
                    }
                }
                break;
        }

        return false;
    }

    public static boolean unpile(int column){
        for (int i = 9; i >= 0; i--) {
            if (cont[i][column] != null) {
                cont[i][column] = null;
                return true;
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = column; j < 11; j++) {
                cont[i][j] = cont[i][j + 1];
            }
        }

        return false;
    }

    public static String getData(int id){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (cont[i][j] != null && cont[i][j].getId() == id) {
                    return cont[i][j].toString();
                }
            }
        }

        return "Container not found";
    }

    public static String getHubPlan() {
        StringBuilder plan = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < 12; j++) {
                plan.append(cont[i][j] != null ? "X" : "O");
            }
            plan.append('\n');
        }
        return plan.toString();
    }

    public static int contNumber(String country){
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (cont[i][j] != null && Objects.equals(cont[i][j].getOrigin(), country)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static String checkContainersByWeightAndHub(double weight, int hubNum) {
        String s = "";
        for (int i = 0; i < 12; i++) {
            if (cont[hubNum][i] != null && cont[hubNum][i].getWeight() <= weight) {
                cont[hubNum][i].setInspected(true);
                s += "Container ID: " + cont[hubNum][i].getId() +
                        ", Sender: " + cont[hubNum][i].getSender() +
                        ", Weight: " + cont[hubNum][i].getWeight() +
                        ", Customs Check: " + (cont[hubNum][i].isInspected() ? "Checked" : "Not Checked") +
                        "\n";
            }
        }
        return s;
    }



}
