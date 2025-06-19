import java.util.*;
public class chat_manage extends New_ChatApp {
    public void chat(String s1,String s2)
    {
        ArrayList<String>lst1=new ArrayList<>();
        ArrayList<String>lst2=new ArrayList<>();
        if(!map1.containsKey(s1))
        {
            HashMap<String,ArrayList<String>>inner=new HashMap<>();
            inner.put(s2,lst1);
            map1.put(s1,inner);
            //Alternative Method in Single Line see Below
           // map1.computeIfAbsent(s1, k -> new HashMap<>()).put(s2, lst);
        }
        else if(!map1.get(s1).containsKey(s2)){
            map1.get(s1).put(s2,lst1);
        }
        if(!map1.containsKey(s2))
        {
            HashMap<String,ArrayList<String>>inner=new HashMap<>();
            inner.put(s1,lst2);
            map1.put(s2,inner);
            //Alternative Method in Single Line see Below
           // map1.computeIfAbsent(s2, k -> new HashMap<>()).put(s1, lst);
        }
        else if(!map1.get(s2).containsKey(s1))
        {
            map1.get(s2).put(s1,lst2);
        }
        System.out.println("Write the Message to stop typing enter Stop_Entry\n");
        x.nextLine();
        while(true)
        {
            String str=x.nextLine();
            if(!str.equals("Stop_Entry"))
            {
                map1.get(s1).get(s2).add("FROM USER "+s1+" TO "+s2+": "+str);
                map1.get(s2).get(s1).add("FROM USER "+s1+" TO "+s2+": "+str);
            }
            else
                break;
        }
    }

    
    public void display(String s1,String s2)
    {
        if(map1.containsKey(s1) && map1.get(s1).containsKey(s2))
        {
            ArrayList<String> messages=map1.get(s1).get(s2);
            System.out.println("Chat Between "+s1+" and "+s2+" :\n");
            for(String i:messages)
            {
                System.out.println(i);
            }
        }
        else
        {
            System.out.println("No such chat is available between "+s1+" and "+s2+"\n");
        }
    }
}
