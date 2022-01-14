package com.devopsusach2020;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.devopsusach2020.rest.RestData;

@SpringBootTest
@AutoConfigureMockMvc
class DevOpsUsach2020ApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads(ApplicationContext context) {
		assertThat(context).isNotNull();
	}

	@Test
	void noEncuentraPais() throws Exception{
		//RestData r = new RestData();

		this.mvc.perform(get("/estadoPais?pais=")).andExpect(status().isNotFound());


		//assertThat(r.getTotalPais("")).;
		
		// MediaLibraries mediaLibraries = createMediaLibrariesObject();//creates mediaLibraries Object; code not shown
        // given(libraryService.getAllLibraries(collectionId,offset,limit)).willReturn(mediaLibraries); //mocking the service

        // mvc.perform(get("assetservice/rest/v1.0/libraries/search/?collectionIds=418A70D0F31010038152080020F03012&offset=0&limit=1"))

        //         .andDo(print())
        //         .andExpect(status().isOk());
	}

	@Test
	void mensajePrueba() throws Exception{
		RestData r = new RestData();

		assertThat(r.getData("Hola Mundo")).isNotNull();

		//this.mvc.perform(get("/estadoPais?pais=")).andExpect(status().isNotFound());


		//assertThat(r.getTotalPais("")).;
		
		// MediaLibraries mediaLibraries = createMediaLibrariesObject();//creates mediaLibraries Object; code not shown
        // given(libraryService.getAllLibraries(collectionId,offset,limit)).willReturn(mediaLibraries); //mocking the service

        // mvc.perform(get("assetservice/rest/v1.0/libraries/search/?collectionIds=418A70D0F31010038152080020F03012&offset=0&limit=1"))

        //         .andDo(print())
        //         .andExpect(status().isOk());
	}


	@Test
	void datosPais() throws Exception{
		RestData r = new RestData();

		assertThat(r.getTotalPais("Chile")).isNotNull();

		//this.mvc.perform(get("/estadoPais?pais=")).andExpect(status().isNotFound());


		//assertThat(r.getTotalPais("")).;
		
		// MediaLibraries mediaLibraries = createMediaLibrariesObject();//creates mediaLibraries Object; code not shown
        // given(libraryService.getAllLibraries(collectionId,offset,limit)).willReturn(mediaLibraries); //mocking the service

        // mvc.perform(get("assetservice/rest/v1.0/libraries/search/?collectionIds=418A70D0F31010038152080020F03012&offset=0&limit=1"))

        //         .andDo(print())
        //         .andExpect(status().isOk());
	}

}
