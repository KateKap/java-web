package app.rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


import app.datamodel.Mapper;
import app.datamodel.Shop;
import app.service.Service;
import app.view.Templates;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
@Path("/")
public class mainRest {

	private Mapper mapper;

	@GET
	@Path("/")
	public Response shops() {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("spring-config.xml");

		Service service = (Service) cxt.getBean("service");

		List<Shop> Shop = service.selectAllShops();


		String[] myArray = {};
		myArray = Shop.toArray(new String[Shop.size()]);

		String htmll = "";

		for(int i = 0; i <= myArray.length  - 1; i++) {
			htmll = htmll + myArray[i];
		}

        Templates html = new Templates("Shops",  htmll);


		return Response.status(200).entity(html.getHtml()).build();

	}
	@GET
	@Path("/products/{id}")
	public Response products(@PathParam("id") int idUrl) {



		return Response.status(200).entity("products " + idUrl).build();

	}

}