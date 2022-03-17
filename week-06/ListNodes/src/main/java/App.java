import java.util.ArrayList;
import java.util.List;

public class App {


    public static void main(String[] args) {

        ListNodes l1 = new ListNodes();
        ListNodes l2 = new ListNodes();

        System.out.println(mergeTwoLists(l1, l2));
    }



    public static ListNodes mergeTwoLists(ListNodes l1, ListNodes l2){
        ListNodes list1 = l1;

        ListNodes list2 = l2;

        List<ListNodes> combinedList = new ArrayList<>();

        while(list2.next != null && list1.next != null){
                if(list1.val < list2.val){
                    combinedList.add(list1);
                    list1 = list1.next;
                }else if(list2.val < list1.val){
                    combinedList.add(list2);
                    list2 = list2.next;
                }else if(list1.val == list2.val){
                    combinedList.add(list1);
                    combinedList.add(list2);
                }else if(list1 == null){
                    combinedList.add(list2);
                    list2 = list2.next;
                }else if(list2 == null){
                    combinedList.add(list1);
                    list1 = list1.next;
                }
        }

      for(int i = 0; i < combinedList.size() - 1; i++){
          combinedList.get(i).next = combinedList.get(i + 1);
      }
      return combinedList.get(0);

    }

}
