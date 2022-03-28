//package memories.ui;
//
//import memories.data.DataAccessException;
//import memories.domain.MemoryResult;
//import memories.domain.MemoryService;
//import memories.models.Memory;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class Controller {
//
//    private final View view;
//    private final MemoryService service;
//
//    public Controller(View view, MemoryService service) {
//        this.view = view;
//        this.service = service;
//    }
//
//    public void run() {
//        view.displayHeader("Welcome to Memories.");
//        try {
//            runApp();
//        } catch (DataAccessException ex) {
//            view.displayErrors(List.of(ex.getMessage()));
//        }
//        view.displayMessage("Goodbye.");
//    }
//
//    private void runApp() throws DataAccessException {
//
//        for (int option = view.chooseMenuOption();
//             option > 0;
//             option = view.chooseMenuOption()) {
//
//            switch (option) {
//                case 1:
//                    viewMemories();
//                    break;
//                case 2:
//                    addMemory();
//                    break;
//                case 3:
//                    updateMemory();
//                    break;
//                case 4:
//                    deleteMemory();
//                    break;
//            }
//        }
//    }
//
//    private void viewMemories() throws DataAccessException {
//        List<Memory> memories = getMemories("View Memories");
//        view.displayMemories(memories);
//    }
//
//    private void addMemory() throws DataAccessException {
//        Memory m = view.createMemory();
//        MemoryResult result = service.add(m);
//        if (result.isSuccessful()) {
//            view.displayMessage("Memory " + result.getMemory().getId() + " created.");
//        } else {
//            view.displayErrors(result.getMessages());
//        }
//    }
//
//    private void updateMemory() throws DataAccessException {
//        List<Memory> memories = getMemories("Update a Memory");
//        Memory m = view.chooseMemory(memories);
//        if (m == null) {
//            view.displayMessage("Memory not found.");
//            return;
//        }
//        m = view.editMemory(m);
//        MemoryResult result = service.update(m);
//        if (result.isSuccessful()) {
//            view.displayMessage("Memory " + result.getMemory().getId() + " updated.");
//        } else {
//            view.displayErrors(result.getMessages());
//        }
//    }
//
//    private void deleteMemory() throws DataAccessException {
//        List<Memory> memories = getMemories("Delete a Memory");
//        Memory m = view.chooseMemory(memories);
//        if (m != null && service.delete(m).isSuccessful()) {
//            view.displayMessage("Memory " + m.getId() + " deleted.");
//        } else {
//            view.displayMessage("Memory not found.");
//        }
//    }
//
//    private List<Memory> getMemories(String title) throws DataAccessException {
//        view.displayHeader(title);
//        if (view.isPublic()) {
//            return service.findPublicMemories();
//        }
//        return service.findPrivateMemories();
//
//    }
//}
