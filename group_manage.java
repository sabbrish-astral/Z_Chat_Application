import java.util.ArrayList;
public class group_manage extends New_ChatApp {
    public void create_group(String name, String admin) {
        boolean exists = false;
        for (Group g : group_lst) {
            if (g.name.equals(name)) {
                exists = true;
                break;
            }
        }
        if (!exists && map.containsKey(admin)) {
            Group group = new Group(name, admin);
            group_lst.add(group);
            System.out.println("Group '" + name + "' created successfully.");
        } else {
            System.out.println("Group name already exists or admin is not a valid user.");
        }
    }



    public void add_members(String gname,ArrayList<String> members_name)
    {
        boolean exist=false;
        for(Group g:group_lst)
        {
            if(g.name.equals(gname))
            {
                for(String s:members_name)
                {
                    if(map.containsKey(s))
                        g.members.add(s);
                    else
                        System.out.println("The Name "+s+" is not a User so Not Added");
                }
                exist=true;
                break;
            }
        }
        if(!exist)
        {
            System.out.println("The Group Name "+gname+" is not available");
        }
    }


    public void Group_Details_display(String s)
    {
        boolean exist=false;
        for(Group g:group_lst)
        {
            exist=true;
            if(g.name.equals(s))
            {
                System.out.println("The Group Name & Admin_Name is:");
                System.out.println(s+" "+g.admin);
                System.out.println("The Group Members are:");
                System.out.println(g.members);
            }
        }
        if(!exist)
        {
            System.out.println("The Group Name "+s+" is not Available");
        }
    }


    public void admin_change(String gname,String A_name)
    {
        boolean exist=false;
        for(Group g:group_lst)
        {
            if(g.name.equals(gname))
            {
                g.admin=A_name;
                exist=true;
                break;
            }
        }
        if(!exist)
        {
            System.out.println("Entered Group name is not available");
        }
    }


    public void Remove_member(String gname,String M_name)
    {
        boolean exist=false;
        for(Group g:group_lst)
        {
            if(g.name.equals(gname))
            {
                for(String s:g.members)
                {
                    if(s.equals(M_name))
                    {
                        g.members.remove(s);
                        break;
                    }
                }
                exist=true;
                break;
            }
        }
        if(!exist)
        {
            System.out.println("Entered Group name is not available");
        }
    }


    public void Remove_group(String gname)
    {
        boolean exist=false;
        for(Group g:group_lst)
        {
            if(g.name.equals(gname))
            {
                group_lst.remove(g);
                exist=true;
                break;
            }
        }
        if(!exist)
        {
            System.out.println("Entered Group name is not available");
        }
    }
}
