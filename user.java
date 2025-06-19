import java.util.*;
public class user extends New_ChatApp {

    public void  add(String str)
    {
        ArrayList<String>s=new ArrayList<>();
        map.put(str,s);
    }


    public void  delete(String str)  
    {
        if(map.containsKey(str))
        {
            map.remove(str);
        }
        else
            System.out.println("Entered User is not in Chat_Application for __Removing__\n");
    }


    public void block(String s1,String s2)
    {
        if(map.containsKey(s2))
        {
            map.get(s1).add(s2);
        }
        else
            System.out.print("Entered User is not in Chat_Application for __Blocking__");
        if(map.containsKey(s1) && map.containsKey(s2))
        {
            if (!s1.equals(s2)) {
                map.get(s1).add(s2);
            }
            else {
                System.out.println("You cannot block yourself.\n");
            }
        }
        else {
            System.out.println("One or both users not found for __Blocking__\n");
        }
    }


    public void unblock(String s1,String s2)
    {
        if(map.containsKey(s1))
        {
            map.get(s1).remove(s2);
        }
        else
            System.out.print("Entered User_List is not in Chat_Application for __UnBlocking__\n");
    }


    public void display()
    {
        for(Map.Entry<String,ArrayList<String>>i:map.entrySet())
        {
            System.out.println(i.getKey());
        }
    }


    public void block_list(String str)
    {
        if(map.containsKey(str)) {
            System.out.println("Blocked Users of " + str + ": " + map.get(str)+"\n");
        } 
        else {
        System.out.println("User not found.\n");
        }
    }
}
