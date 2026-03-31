package dsaHackathon;
class VehicleNode
{
    int vid;
    String type;
    String vtype;
    String name;
    int time;
    int priority;
    double amt;

    VehicleNode link;

    public VehicleNode(int vid, String type, String vtype, String name, int time, int priority, double amt)
    {
        this.vid = vid;
        this.type = type;
        this.vtype = vtype;
        this.name = name;
        this.time = time;
        this.priority = priority;
        this.amt = amt;
        this.link = null;
    }
}