package dsaHackathon;
import java.util.Scanner;
public class TrafficManagementSystem
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        LL list=new LL();
        Queue q=new Queue(10);
        Heap heap=new Heap(10);
        Stack stack=new Stack(10);
        HashTable ht=new HashTable();
        FileHandler fh=new FileHandler();

        fh.load(list);
        System.out.println();
        int ch;

        do
        {
            System.out.println("------TRAFFIC MANAGEMENT SYSTEM------");
			System.out.println("1.Add Record");
			System.out.println("2.Display Record");
			System.out.println("3.Search Record by Name");
			System.out.println("4.Search Record by ID");
			System.out.println("5.Sort Record");
			System.out.println("6.Enqueue");
			System.out.println("7.Handle Priority");
			System.out.println("8.Undo");
			System.out.println("9.Display Hash");
			System.out.println("10.Save to File");
			System.out.println("Enter 0 to EXIT");
			System.out.println("Enter your choice ");
            ch=sc.nextInt();

            switch(ch)
            {
                case 1: sc.nextLine();
                        System.out.print("Vehicle ID: "); 
                        int id=sc.nextInt();
                        sc.nextLine();
                
                        System.out.print("Vehicle Type: ");
                        String type=sc.nextLine();
                
                        System.out.print("Violation Type: ");
                        String vt=sc.nextLine();
                
                        System.out.print("Vehicle Owner Name: ");
                        String name=sc.nextLine();
                
                        System.out.print("Time(hrs): ");
                        int t=sc.nextInt();
                
                        System.out.print("Priority: ");
                        int p=sc.nextInt();
                
                        System.out.print("Fine Amount: ");
                        double amt=sc.nextDouble();

                        list.addRecord(id,type,vt,name,t,p,amt);
                        break;

                    
                case 2: list.displayRecords();
                        break;

                        
                case 3: sc.nextLine();
                	    System.out.println("Enter the name to search");
                	    String na=sc.nextLine();
                        list.linearSearch(na);
                        break;

                        
                case 4: System.out.println("Enter Vehicle ID to Search");
                        int vid=sc.nextInt();
                	    list.binarySearch(vid);
                	    break;

                	    
                case 5: System.out.println("Select Sorting Technique");
                        System.out.println("1.Bubble 2.Insertion 3.Quick");
                        int s=sc.nextInt();
                        if(s==1)
                        {
                        	list.bubbleSort();
                        }
                        else if(s==2)
                        {
                        	list.insertionSort();
                        }
                        else
                        {
                        	list.quickSort();
                        }
                        break;

                        
                case 6: q.enqueue(list.getLast());
                        break;

                        
                case 7: heap.insert(list.getLast());
                        VehicleNode v=heap.delete();
                        if(v!=null)
                        {
                            System.out.println("Processed Priority: "+v.vid);
                            stack.push(v);
                            ht.insert(v);
                        }
                        break;

                        
                case 8: VehicleNode u=stack.pop();
                        if(u!=null)
                        {
                            list.deleteById(u.vid);
                            q.enqueue(u);
                            System.out.println("Undo Done");
                        }
                        break;

                        
                case 9: ht.display();
                        break;

                        
                case 10:fh.save(list);
                        break;
            }

        }while(ch!=0);
        sc.close();
    }
}