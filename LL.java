package dsaHackathon;
class LL
{
    public VehicleNode head = null;

    public void addRecord(int vid, String type, String vtype, String name, int time, int priority, double amt)
    {
        VehicleNode newnode = new VehicleNode(vid,type,vtype,name,time,priority,amt);

        if(head == null)
        {
            head = newnode;
        }
        else
        {
            VehicleNode temp = head;
            while(temp.link != null)
            {
                temp = temp.link;
            }
            temp.link = newnode;
        }
    }

    public VehicleNode getLast()
    {
        VehicleNode temp = head;
        while(temp.link != null)
        {
            temp = temp.link;
        }
        return temp;
    }

    public void deleteById(int id)
    {
        if(head == null)
        {
        	return;
        }

        if(head.vid == id)
        {
            head = head.link;
            return;
        }

        VehicleNode temp = head;
        while(temp.link != null && temp.link.vid != id)
        {
            temp = temp.link;
        }

        if(temp.link != null)
        {
            temp.link = temp.link.link;
        }
    }

    public void displayRecords()
    {
        VehicleNode temp = head;
        while(temp != null)
        {
            System.out.println(temp.vid+" | "+temp.name+" | "+temp.type+" | "+temp.vtype+" | "+temp.time+" | "+temp.priority+" | "+temp.amt);
            temp = temp.link;
        }
    }

    public void linearSearch(String name)
    {
        VehicleNode temp = head;
        while(temp != null)
        {
            if(temp.name.equalsIgnoreCase(name))
            {
                System.out.println("Found ID: "+temp.vid);
            }
            temp = temp.link;
        }
    }

    public VehicleNode[] toArray()
    {
        int n=0;
        VehicleNode temp=head;
        while(temp!=null)
        {
        	n++;
        	temp=temp.link;
        }

        VehicleNode a[]=new VehicleNode[n];
        temp=head;
        int i=0;

        while(temp!=null)
        {
            a[i++]=temp;
            temp=temp.link;
        }
        return a;
    }

    public void bubbleSort()
    {
        VehicleNode a[]=toArray();

        for(int i=0;i<a.length-1;i++)
        {
            for(int j=0;j<a.length-i-1;j++)
            {
                if(a[j].time > a[j+1].time)
                {
                    VehicleNode t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
        }

        for(VehicleNode v:a)
        {
        	System.out.println(v.vid+" | "+v.name+" | "+v.type+" | "+v.vtype+" | "+v.time+" | "+v.priority+" | "+v.amt);
            //System.out.println(v.vid+" "+v.time);
        }
    }

    public void insertionSort()
    {
        VehicleNode a[]=toArray();

        for(int i=1;i<a.length;i++)
        {
            VehicleNode key=a[i];
            int j=i-1;

            while(j>=0 && key.priority > a[j].priority)
            {
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=key;
        }

        for(VehicleNode v:a)
        {
        	System.out.println(v.vid+" | "+v.name+" | "+v.type+" | "+v.vtype+" | "+v.time+" | "+v.priority+" | "+v.amt);
        	//System.out.println(v.vid+" "+v.priority);
        }
    }

    public void quickSort()
    {
        VehicleNode a[]=toArray();
        quick(a,0,a.length-1);

        for(VehicleNode v:a)
        {
        	System.out.println(v.vid+" | "+v.name+" | "+v.type+" | "+v.vtype+" | "+v.time+" | "+v.priority+" | "+v.amt);
        	//System.out.println(v.vid+" "+v.time);
        }
    }

    private void quick(VehicleNode a[],int low,int high)
    {
        if(low<high)
        {
            int pi=partition(a,low,high);
            quick(a,low,pi-1);
            quick(a,pi+1,high);
        }
    }

    private int partition(VehicleNode a[],int low,int high)
    {
        int pivot=a[high].time;
        int i=low-1;

        for(int j=low;j<high;j++)
        {
            if(a[j].time<pivot)
            {
                i++;
                VehicleNode t=a[i];
                a[i]=a[j];
                a[j]=t;
            }
        }

        VehicleNode t=a[i+1];
        a[i+1]=a[high];
        a[high]=t;
        return i+1;
    }

    public void binarySearch(int id)
    {
        VehicleNode a[]=toArray();

        for(int i=0;i<a.length-1;i++)
        {
            for(int j=0;j<a.length-i-1;j++)
            {
                if(a[j].vid>a[j+1].vid)
                {
                    VehicleNode t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
        }

        int low=0,high=a.length-1;

        while(low<=high)
        {
            int mid=(low+high)/2;

            if(a[mid].vid==id)
            {
                System.out.println("Found ID");
                return;
            }
            else if(a[mid].vid<id)
            {
            	low=mid+1;
            }
            else
            {
            	high=mid-1;
            }
        }

        System.out.println("Not Found");
    }
}