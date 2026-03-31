package dsaHackathon;
class HashTable
{
    VehicleNode table[];
    int size = 10;

    HashTable()
    {
        table = new VehicleNode[size];
    }

    int hash(int key)
    {
        return key % size;
    }

    void insert(VehicleNode v)
    {
        int i = hash(v.vid);

        while(table[i] != null)
        {
            i = (i+1)%size;
        }

        table[i] = v;
    }

    void display()
    {
        for(int i=0;i<size;i++)
        {
            if(table[i]!=null)
            {
                System.out.println(table[i].vid+" -> "+table[i].name);
            }
        }
    }
}