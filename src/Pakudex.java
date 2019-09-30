import java.util.Arrays;

public class Pakudex
{
    // variable dump
    private int capacity;
    private int size;
    private Pakuri[] collection;



    public Pakudex()
    {
        this(20);
    }

    public Pakudex(int capacity)
    {
        this.capacity = capacity;
        collection = new Pakuri[capacity];
    }

    public int getSize()
    {
        return size;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public String[] getSpeciesArray()
    {
        if (size == 0)
        {
            return null;
        }

        String[] pakuriList = new String[size];

        for(int i = 0; i < size; i++)
        {
            pakuriList[i] = collection[i].getSpecies();
        }

        return pakuriList;
    }

    public int[] getStats(String species)
    {
        for (int i = 0; i < size; i++)
        {
            if (collection[i].getSpecies().equals(species))
            {
                return new int[] {collection[i].getAttack(), collection[i].getDefense(), collection[i].getSpeed()};
            }
        }

        return null;
    }


    public void sortPakuri()
    {
        Arrays.sort(collection, 0, size);
    }


    public boolean addPakuri(String species)
    {
        if (size == capacity)
        {
            return false;
        }
        if (getStats(species) == null)
        {
            collection[size] = new Pakuri(species);
            size ++;
            return true;
        }
        else
        {
            return false;
        }


    }

    public boolean evolveSpecies(String species)
    {
        for (int i = 0; i < size; i++)
        {
            if (collection[i].getSpecies().equals(species))
            {
                collection[i].evolve();
                return true;
            }
        }

        return false;
    }









}
