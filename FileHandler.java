package dsaHackathon;
import java.io.FileReader;
import java.io.FileWriter;

class FileHandler
{
    void save(LL list)
    {
        try
        {
            FileWriter fw = new FileWriter("data.txt");

            VehicleNode temp = list.head;

            while(temp != null)
            {
                fw.write(
                    temp.vid + "," +
                    temp.type + "," +
                    temp.vtype + "," +
                    temp.name + "," +
                    temp.time + "," +
                    temp.priority + "," +
                    temp.amt + "\n"
                );

                temp = temp.link;
            }

            fw.close();
            System.out.println("Data Saved to data.txt");
        }
        catch(Exception e)
        {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    
    void load(LL list)
    {
        try
        {
            FileReader fr = new FileReader("data.txt");

            String line = "";
            int ch;

            while((ch = fr.read()) != -1)
            {
                if(ch == '\n')
                {
                    processLine(line, list);
                    line = "";
                }
                else
                {
                    line += (char)ch;
                }
            }


            if(!line.equals(""))
            {
                processLine(line, list);
            }

            fr.close();
            System.out.println("Data Loaded from File.");
        }
        catch(Exception e)
        {
            System.out.println("No previous file found");
        }
    }


    void processLine(String line, LL list)
    {
        try
        {
            String p[] = line.split(",");

            list.addRecord(
                Integer.parseInt(p[0]),
                p[1],
                p[2],
                p[3],
                Integer.parseInt(p[4]),
                Integer.parseInt(p[5]),
                Double.parseDouble(p[6])
            );
        }
        catch(Exception e)
        {
            System.out.println("Skipping invalid line");
        }
    }
}