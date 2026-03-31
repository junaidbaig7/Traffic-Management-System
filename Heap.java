package dsaHackathon;

class Heap
{
    VehicleNode heap[];
    int size=0;

    Heap(int n)
    {
        heap=new VehicleNode[n];
    }

    void insert(VehicleNode v)
    {
        heap[size]=v;
        int i=size++;

        while(i>0 && heap[(i-1)/2].priority < heap[i].priority)
        {
            VehicleNode t=heap[i];
            heap[i]=heap[(i-1)/2];
            heap[(i-1)/2]=t;
            i=(i-1)/2;
        }
    }

    VehicleNode delete()
    {
        if(size==0)
        {
        	return null;
        }

        VehicleNode root=heap[0];
        heap[0]=heap[--size];
        heapify(0);

        return root;
    }

    void heapify(int i)
    {
        int largest=i,l=2*i+1,r=2*i+2;

        if(l<size && heap[l].priority>heap[largest].priority)
        {
        	largest=l;
        }
        if(r<size && heap[r].priority>heap[largest].priority)
        {
        	largest=r;
        }

        if(largest!=i)
        {
            VehicleNode t=heap[i];
            heap[i]=heap[largest];
            heap[largest]=t;
            heapify(largest);
        }
    }
}