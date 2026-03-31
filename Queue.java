package dsaHackathon;

class Queue
{
    VehicleNode arr[];
    int front=-1;
    int rear=-1;
    int size;
    boolean isCircular=false;

    Queue(int n)
    {
        size=n;
        arr=new VehicleNode[n];
    }

    void enqueue(VehicleNode v)
    {
        if(!isCircular)
        {
            if(rear==size-1)
            {
                System.out.println("Switching to Circular Queue");
                isCircular=true;
            }
            else
            {
                arr[++rear]=v;
                if(front==-1) front=0;
                return;
            }
        }

        if((rear+1)%size==front)
        {
            System.out.println("Queue Full");
            return;
        }

        rear=(rear+1)%size;
        arr[rear]=v;
    }

    VehicleNode dequeue()
    {
        if(front==-1)
        {
            System.out.println("Empty");
            return null;
        }

        VehicleNode temp=arr[front];

        if(front==rear)
        {
            front=rear=-1;
        }
        else
        {
            front=(front+1)%size;
        }

        return temp;
    }
}