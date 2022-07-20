package mypack;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class Dog
{
    public  void  eating()
    {
        System.out.println("i am eating food");
    }
}
