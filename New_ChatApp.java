import java.util.*;
class Group
{
    String name;
    String admin;
    Set<String>members=new HashSet<>();

    Group(String name,String admin)
    {
        this.name=name;
        this.admin=admin;
        members.add(admin);
    }
}

public class New_ChatApp {
    public static HashMap<String,ArrayList<String>> map=new HashMap<>();//case 1,2,3,4,5,6
    public static HashMap<String,HashMap<String,ArrayList<String>>> map1=new HashMap<>();//case 7(chat)
    public static List<Group>group_lst=new ArrayList<>();//case 8(group manage)
    public static ArrayList<String>members_name=new ArrayList<>();
    public static Scanner x=new Scanner(System.in);


    public static void main(String[] args) {
        user u=new user();
        chat_manage cm=new chat_manage();
        group_manage gm=new group_manage();
        boolean exit=true;
        System.out.println("Welcome to ChatAppliction");
        String str,str1;
        while (exit) {
            System.out.println("\nSelect the below\n");
            System.out.printf("1)Add User\n2)Delete User\n3)Block User\n4)UnBlock User\n5)Display_Users\n6)User BlockList\n7)Chat_Application\n8)Group_Functions\n9)Exit\n\n");
            int no=x.nextInt();
            switch (no) {
                case 1:
                    System.out.println("Enter User Name:");
                    str=x.next();
                    u.add(str);
                    break;
                case 2:
                    System.out.println("Enter User Name:");
                    str=x.next();
                    u.delete(str);
                    break;
                case 3:
                    System.out.println("Enter User Name:");
                    str=x.next();
                    System.out.println("Enter Block_User Name:");
                    str1=x.next();
                    u.block(str,str1);
                    break;
                case 4:
                    System.out.println("Enter User Name:");
                    str=x.next();
                    System.out.println("Enter User Name for UnBlocking:");
                    str1=x.next();
                    u.unblock(str,str1);
                    break;
                case 5:
                    System.out.println("_Displaying_Users_..........");
                    u.display();
                    break;
                case 6:
                    System.out.println("Enter User Name:");
                    str=x.next();
                    u.block_list(str);
                    break;
                case 7:
                    System.out.println("U are Entering into Chat_Application...........");
                    System.out.println("Choose the Below Functions:\n");
                    System.out.printf("1)Chat With Others\n2)Display Chats\n");
                    int n=x.nextInt();
                    switch (n) {
                        case 1:
                            System.out.println("Enter User Name:");
                            str=x.next();
                            System.out.println("Sender User Name:");
                            str1=x.next();
                            cm.chat(str,str1);
                            break;
                        case 2:
                            System.out.println("Enter User Name:");
                            str=x.next();
                            System.out.println("Chat of User Name:");
                            str1=x.next();
                            cm.display(str,str1);
                            break;
                    }
                    break;
                case 8:
                    System.out.println("Entering Group Functions............");
                    System.out.println("Choose the below functions");
                    System.out.println("1)Create new Group\n2)Add Members to Group\n3)Change Admin\n4)Remove Members\n5)Remove Group\n6)Display Group Details\n");
                    int a=x.nextInt();
                    
                    switch (a) {
                        case 1:
                            System.out.println("Enter Group Name:");
                            str=x.next();
                            System.out.println("Enter Admin Name:");
                            str1=x.next();
                            gm.create_group(str,str1);
                            break;
                        case 2:
                            System.out.println("Enter Stop_Entry to stop getting input:");
                            System.out.println("Enter Group Name");
                            str1=x.next();
                            System.out.println("Enter the Members Name:");
                            while(true)
                            {
                                str=x.next();
                                if(!str.equals("Stop_Entry") && map.containsKey(str))
                                {
                                    members_name.add(str);
                                }
                                else if(!str.equals("Stop_Entry") && !map.containsKey(str)){
                                    System.out.println("The entered user name "+str+" is not availble so not added");
                                }
                                else
                                    break;
                            }
                            gm.add_members(str1,members_name);
                            break;
                        case 3:
                            System.out.println("Enter the New_Admin name:");
                            str=x.next();
                            System.out.println("Enter the Group name");
                            str1=x.next();
                            gm.admin_change(str1,str);
                            break;
                        case 4:
                            System.out.println("Enter the Gropu name:");
                            str=x.next();
                            System.out.println("Enter the Member name to remove:");
                            str1=x.next();
                            gm.Remove_member(str,str1);
                            break;
                        case 5:
                            System.out.println("Enter the Gropu name to be removed:");
                            str=x.next();
                            gm.Remove_group(str);
                            break;
                        case 6:
                            System.out.println("Enter The Group Name for Details");
                            str=x.next();
                            System.out.println("Displaying the Gropu Details.........");
                            gm.Group_Details_display(str);
                            break;
                    }
                    break;
                case 9:
                    exit=false;
                    break;
            }
        }
    }
}