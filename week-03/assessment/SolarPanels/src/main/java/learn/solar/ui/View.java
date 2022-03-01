package learn.solar.ui;

import learn.solar.domain.PanelResult;
import learn.solar.models.Material;
import learn.solar.models.Panel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

    private final Scanner console = new Scanner(System.in);



    public int chooseOptionFromMenu(){
        printHeader("Main menu");



        System.out.print("0. Exit\n");
        System.out.print("1. Find Panels by Section\n");
        System.out.print("2. Add a panel\n");
        System.out.print("3. Update a Panel\n");
        System.out.print("4. Remove a Panel\n");
        System.out.print("Select [0-4]: \n");

        return readInt("Please enter your selection: ", 0, 4);

    }

    public void printHeader(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println("=".repeat(message.length()));
    }



    private String readString(String message){
        System.out.print(message);
        return console.nextLine();
    }

    private String readRequiredString(String message){
       String result;
       do{
           result = readString(message);
           if(result.trim().length() == 0){
               System.out.println("Value is required.");
           }
       }while(result.trim().length() == 0);
       return result;
    }

    private int readInt(String message){
        String input = null;
        int result = 0;
        boolean isValid = false;
        do{

                input = readRequiredString(message);
                try{
                result = Integer.parseInt(input);
                isValid = true;
            }catch(NumberFormatException ex){
                System.out.printf("%s is not a valid number,%n", input);
            }
        }while(!isValid);

        return result;
    }

    private int readInt(String message, int min, int max){
        int result = 0;
        do{
            result = readInt(message);
            if(result < min || result > max){
                System.out.printf("Value must be between %s and %s.%n", min, max);
            }
        }while(result < min || result > max);



        return result;
    }

    private Material readMaterial(){
        int index = 1;
        for(Material material : Material.values()){
            System.out.printf("%s. %s%n", index++, material);
        }
        index--;
        String message = String.format("Select Material [1-%s]: ", index);
        return Material.values()[readInt(message, 1, index) - 1];
    }


    public String readSection(){
        List<Panel> panels = new ArrayList<>();
        int index = 1;
        for(Panel p : panels.findBySection()){
            System.out.printf("%s. %s%n", index++, p);
        }
        index--;
        String message = String.format("Select Material [1-%s]: ", index);
        return panels.findBySection()[readInt(message, 1, index) - 1];

    }

    public void printPanels(String sectionName, List<Panel> panels){
        printHeader("Panels: :");
        if(panels.size() == 0){
            System.out.println("No panels found");
        }else{
            for(Panel p : panels){
                System.out.printf("ID: %s, Section: %s, Row: %s, Column: %s, Installation Year: %s, Material: %s, Tracking: %s",
                        p.getId(),
                        p.getSection(),
                        p.getRow(),
                        p.getColumn(),
                        p.getInstallationYear(),
                        p.getMaterial(),
                        p.isTracking());
            }
        }
    }


    public void printResult(PanelResult result){
        if(result.isSuccess()){
            printHeader("Success!");
        }else{
            printHeader("Error:");
            for(String error : result.getMessages()){
                System.out.println(error);
            }
        }
    }

    public Panel makePanel(){

        Panel panel = new Panel();
        //panel.setId();
        panel.setSection(readRequiredString("Section: "));
        panel.setRow(readInt("Row: ", 0, Integer.MAX_VALUE));
        panel.setColumn(readInt("Column: ", 0, Integer.MAX_VALUE));
        panel.setInstallationYear(readInt("Year: ", Integer.MIN_VALUE, 2022));
        panel.setMaterial(readMaterial());
//        panel.setTracking();
        return panel;


    }


    public Panel update(List<Panel> panels){
        Panel panel = findPanel(panels);
        if(panel != null){
            update(panel);
        }
        return panel;
    }


    private Panel update(Panel panel){
        String section = readString("Section (" + panel.getSection() + "): ");
        if(section.trim().length() > 0){
            panel.setSection(section);
        }
        return panel;
    }

    public Panel findPanel(List<Panel> panels){
            String section = "";
            printPanels(section, panels);
            if(panels.size() == 0){
                return null;
            }

            int panelId = readInt("Panel Id: ");
            for(Panel p : panels){
                if(p.getId() == panelId){
                    return update(p);
                }
            }
            System.out.println("Panel ID " + panelId + " not found.");
            return null;
    }




    /*
    - `private Scanner console` -- a Scanner to be used across all methods
- `public int chooseOptionFromMenu()` -- display the main menu and select an option, used to Controller.run()
- `public void printHeader(String)` -- display text to the console with emphasis
- `public void printResult(PanelResult)` -- display a PanelResult with either success or failure w/ messages included
- `public void printPanels(String sectionName, List<Panel>)` -- display panels in a section with the section's name
- `public Panel choosePanel(String sectionName, List<Panel>)` -- choose a panel from a list of options (useful for update and delete)
- `public Panel makePanel()` -- make a panel from scratch, used in Controller.addPanel
- `public Panel update(Panel)` -- accept and existing Panel, update it, and return it, used in Controller.updatePanel
- `public String readSection()` -- reads a section name, used in Controller: viewBySection, updatePanel (must search first), and deletePanel
- `private String readString(String)` -- general-purpose console method for reading a string
- `private String readRequiredString(String)` -- general-purpose console method for reading a required string
- `private int readInt(String)` -- general-purpose console method for reading an integer
- `private int readInt(String, int min, int max)` -- general-purpose console method for reading an integer with a min and max
- `private Material readMaterial()` -- domain-specific console method for choosing a Material
     */


/*
    Create `View`
            *- add `Scanner` field
    *- create read* methods: `readString`, `readRequiredString`, `readInt`, `readInt` (with min/max)
 */
}
