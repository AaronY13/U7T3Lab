import java.util.ArrayList;

public class CustomerCheck
{
    /** The check for a customer or group of customers
     *  Guaranteed to contain at least one MenuItem and all entries are non-null
     */
    private ArrayList<MenuItem> check;

    /* Constructor */
    public CustomerCheck(ArrayList<MenuItem> check)
    {
        this.check = check;
    }

    /** Returns the total of all MenuItem prices on the check,
     *  as described in part (a)
     */
    public double totalPrices()
    {
        double sum = 0;
        for (MenuItem item : check)
        {
            sum += item.getPrice();
        }
        return sum;
    }

    /** Returns true if the restaurant’s coupon offer can be applied to this check and
     *  returns false otherwise, as described in part (b) */
    public boolean couponApplies()
    {
        boolean special = false;
        for (MenuItem item : check)
        {
            if (item.isDailySpecial())
            {
                special = true;
            }
        }
        if (totalPrices() < 40.00)
        {
            return false;
        }
        else if (special)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /** Calculates the final cost of this check, as described in part (c) */
    public double calculateCheck()
    {
        double sub = totalPrices();
        int customers = 0;
        double discount = 0;
        double tax = 0;
        for (MenuItem item : check)
        {
            if (item.isEntree())
            {
                customers ++;
            }
        }

        if (customers >= 6)
        {
            tax = sub * 0.2;
        }
        if (couponApplies())
        {
           discount = sub * -0.25;
        }
        return sub + tax + discount;
    }
}