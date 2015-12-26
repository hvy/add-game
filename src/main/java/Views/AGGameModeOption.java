package Views;

public enum AGGameModeOption {
    ADD_1("Add-1", 1),
    ADD_3("Add-3", 3),
    ADD_X("Add-X");

    String name;
    int x = 0;
    
    AGGameModeOption(String name) {
       this.name = name;
    }
    AGGameModeOption(String name, int x) {
        this.name = name;
        this.x = x;
    }
}
