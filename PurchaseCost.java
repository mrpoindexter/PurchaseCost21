
package purchasecost;
import java.util.Scanner;

 /* @author Ahnaf Abid Khan */

public class PurchaseCost {

    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        Foreign F = new Foreign();
        Foreign L = new Local();
        Local L1 = new Local();
        
        
        System.out.println("Enter the price of all the imported necessity products: ");
        F.setNecessities(S.nextDouble());
        System.out.println("Enter the price of all the imported luxurious products: ");
        F.setLuxuries(S.nextDouble());
        System.out.println("Enter the location: ");
        F.location = S.next();
        F.TransportationCost(F);
        
        
        System.out.println("Enter the price of all the transported necessity products: ");
        L.setNecessities(S.nextDouble());
        System.out.println("Enter the price of all the transported luxurious products: ");
        L.setLuxuries(S.nextDouble());
       
        System.out.println("Enter the location: ");
        L.location = S.next();
        L.TransportationCost(L);
        
        
        System.out.println("Enter the price of all the transported inferior products: ");
        L1.setInferiors(S.nextDouble());
        System.out.println("Enter the weight of inferior products: ");
        L1.weight = S.nextDouble();
        L1.CostOnInferiors();
        System.out.println("The cost of transporting inferior products is: " +L1.CostOnInferiors());
        System.out.println("The total cost of transporting inferior products is: " +(L1.getInferiors() + L1.CostOnInferiors()));
        
        
        
        double a = F.sum + L.sum + (L1.CostOnInferiors() + L1.getInferiors());
        System.out.println("Enter the year: ");
        int b = S.nextInt();
        System.out.println("Total purchase cost for the year " +b + " is " +a);
        if(a > 10000000)
        {
            System.out.println("It is too high.");
        }
        else if(a < 10000000 && a > 0)
        {
            System.out.println("It is adequate.");
        }
        else 
        {
            System.out.println("Error in input.");
        }
    }
    
}

package purchasecost;

/* @author Ahnaf Abid Khan */

public class Foreign {
    private double necessities;
    private double luxuries;
    String location;
    double sum = 0.0;
Foreign()
{
    
}
Foreign(double necessities, double luxuries, String location)
{
    this.necessities = necessities;
    this.luxuries = luxuries;
    this.location = location;
}
double getNecessities()
{
    return necessities;
}
void setNecessities(double necessities)
{
    this.necessities = necessities;
}
double getLuxuries()
{
    return luxuries;
}
void setLuxuries(double luxuries)
{
    this.luxuries = luxuries;
}
double ImportedTaxOnNecessities()
{
    double a = getNecessities() * .15;
    return a;
}
double ImportedTaxOnLuxuries()
{
    double b = getLuxuries() * .2;
    return b;
}
void TransportationCost(Foreign F)
{
    if("China".equals(location))
    {
        double c = F.getNecessities() + (F.getNecessities() * .25);
        double d =  c + ImportedTaxOnNecessities();
        System.out.println("The cost of transporting necessity products is: " +(F.getNecessities() * .25));
        System.out.println("The amount of tax imposed on the imported necessity products is: " +F.ImportedTaxOnNecessities());
        System.out.println("The total cost of importing necessity products is: " +d);
        
        
        double e = F.getLuxuries() + (F.getLuxuries() * .25);
        double f = e + ImportedTaxOnLuxuries();
        System.out.println("The cost of transporting luxurious products is: " +(F.getNecessities() * .25));
        System.out.println("The amount of tax imposed on the imported luxurious products is: " +F.ImportedTaxOnLuxuries());
        System.out.println("The total cost of importing luxurious products is: " +f);
        sum = d + f;
    }
    else if("Australia".equals(location))
    {
        double g = F.getNecessities() + (F.getNecessities() * .50);
        double h =  g + ImportedTaxOnNecessities();
        System.out.println("The cost of transporting necessity products is: " +(F.getNecessities() * .50));
        System.out.println("The amount of tax imposed on the imported necessity products is: " +F.ImportedTaxOnNecessities());
        System.out.println("The total cost of importing necessity products is: " +h);
        
        
        double i = F.getLuxuries() + (F.getLuxuries() * .50);
        double j = i + ImportedTaxOnLuxuries();
        System.out.println("The cost of transporting luxurious products is: " +(F.getNecessities() * .50));
        System.out.println("The amount of tax imposed on the imported luxurious products is: " +F.ImportedTaxOnLuxuries());
        System.out.println("The total cost of importing luxurious products is: " +j);
        sum = h + j;
    }
    else if("Canada".equals(location))
    {
        double k = F.getNecessities() + (F.getNecessities() * .75);
        double l =  k + ImportedTaxOnNecessities();
        System.out.println("The cost of transporting necessity products is: " +(F.getNecessities() * .75));
        System.out.println("The amount of tax imposed on the imported necessity products is: " +F.ImportedTaxOnNecessities());
        System.out.println("The total cost of importing necessity products is: " +l);
        
        
        double m = F.getLuxuries() + (F.getLuxuries() * .75);
        double n = m + ImportedTaxOnLuxuries();
        System.out.println("The cost of transporting luxurious products is: " +(F.getNecessities() * .75));
        System.out.println("The amount of tax imposed on the imported luxurious products is: " +F.ImportedTaxOnLuxuries());
        System.out.println("The total cost of importing luxurious products is: " +n);
        sum = l + n;
    }
}
}

package purchasecost;
import java.util.Scanner;

/* @author Ahnaf Abid Khan */

public class Local extends Foreign {
    private double inferiors;
    double weight;
Local()
{
    
}
Local(double inferiors)
{
    this.inferiors = inferiors;
}
double getInferiors()
{
    return inferiors;
}
void setInferiors(double inferiors)
{
    this.inferiors = inferiors;
}
double DiscountReceivedOnNecessities(double rate)
{
    double a = getNecessities() - (getNecessities() * (rate * .01));
    return a;
}
double DiscountReceivedOnLuxuries(double rate)
{
    double b = getLuxuries() - (getLuxuries() * (rate * .01));
    return b;
}
    @Override
void TransportationCost(Foreign F)
{
    Scanner S = new Scanner(System.in);
    if("Dhaka".equals(location))
    {
        double d = (F.getNecessities() * .05);
        System.out.println("Enter the dicount rate on necessities: ");
        double e = S.nextDouble();
        double f = d + DiscountReceivedOnNecessities(e);
        System.out.println("The amount of discount received for purchasing necessity products is: " +(getNecessities() * e * .01));
        System.out.println("The cost of transporting necessity products is: " +d);
        System.out.println("The total cost of transporting necessity products is: " +f);
        
        
        double g = (F.getLuxuries() * .05);
        System.out.println("Enter the dicount rate on luxuries: ");
        double h = S.nextDouble();
        double i = g + DiscountReceivedOnLuxuries(h);
        System.out.println("The amount of discount received for purchasing luxurious products is: " +(getLuxuries() * h * .01));
        System.out.println("The cost of transporting luxurious products is: " +g);
        System.out.println("The total cost of transporting luxurious products is: " +i);
        
        
        sum = i + f;
    }
    else if("Chittagong".equals(location))
    {
        double d = (F.getNecessities() * .10);
        System.out.println("Enter the dicount rate on necessities: ");
        double e = S.nextDouble();
        double f = d + DiscountReceivedOnNecessities(e);
        System.out.println("The amount of discount received for purchasing necessity products is: " +(getNecessities() * e * .01));
        System.out.println("The cost of transporting necessity products is: " +d);
        System.out.println("The total cost of transporting necessity products is: " +f);
        
        
        double g = (F.getLuxuries() * .10);
        System.out.println("Enter the dicount rate on luxuries: ");
        double h = S.nextDouble();
        double i = g + DiscountReceivedOnLuxuries(h);
        System.out.println("The amount of discount received for purchasing luxurious products is: " +(getLuxuries() * h * .01));
        System.out.println("The cost of transporting luxurious products is: " +g);
        System.out.println("The total cost of transporting luxurious products is: " +i);
        
        
        sum = i + f;
    }
    else if("Khulna".equals(location))
    {
        double d = (F.getNecessities() * .15);
        System.out.println("Enter the dicount rate on necessities: ");
        double e = S.nextDouble();
        double f = d + DiscountReceivedOnNecessities(e);
        System.out.println("The amount of discount received for purchasing necessity products is: " +(getNecessities() * e * .01));
        System.out.println("The cost of transporting necessity products is: " +d);
        System.out.println("The total cost of transporting necessity products is: " +f);
        
        
        double g = (F.getLuxuries() * .15);
        System.out.println("Enter the dicount rate on luxuries: ");
        double h = S.nextDouble();
        double i = g + DiscountReceivedOnLuxuries(h);
        System.out.println("The amount of discount received for purchasing luxurious products is: " +(getLuxuries() * h * .01));
        System.out.println("The cost of transporting luxurious products is: " +g);
        System.out.println("The total cost of transporting luxurious products is: " +i);
        
        
        sum = i + f;
    }
}
double CostOnInferiors()
{
    double a = (getInferiors() * .02);
    double b = (getInferiors() * .05);
    double c = (getInferiors() * .1);
    if(weight < 50 || weight == 50)
    {
        return a;
    }
    else if(weight > 50 && weight < 100)
    {
        return b;
    }
    else if(weight > 100 || weight == 100)
    {
       return c;
    }
    else
    {
        return 0;
    }

}
}




