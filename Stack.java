package dsaHackathon;

class Stack
{
    VehicleNode arr[];
    int top=-1;

    Stack(int n)
    {
        arr=new VehicleNode[n];
    }

    void push(VehicleNode v)
    {
        if(top==arr.length-1)
        {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top]=v;
    }

    VehicleNode pop()
    {
        if(top==-1)
        {
        	return null;
        }
        return arr[top--];
    }
}