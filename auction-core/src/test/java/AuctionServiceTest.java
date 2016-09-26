import io.crowdcode.speedbay.auction.service.AuctionService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by SU00079 on 26.09.2016.
 */
public class AuctionServiceTest {

    @Test
    public void testAuctionFromXmlContext() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        context.getBean(AuctionService.class);

        AuctionService auctionService = context.getBean("auctionService", AuctionService.class);

        Assert.assertNotNull(auctionService);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(
                beanName -> System.out.println(beanName)
        );

//        context.close();

    }
}
