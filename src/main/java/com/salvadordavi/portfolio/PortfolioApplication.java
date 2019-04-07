package com.salvadordavi.portfolio;

import com.salvadordavi.portfolio.model.Album;
import com.salvadordavi.portfolio.model.Photo;
import com.salvadordavi.portfolio.model.User;
import com.salvadordavi.portfolio.repository.AlbumRepository;
import com.salvadordavi.portfolio.repository.PhotoRepository;
import com.salvadordavi.portfolio.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class PortfolioApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AlbumRepository albumRepository;

	@Autowired
	private PhotoRepository photoRepository;

	private static Logger LOG = LoggerFactory
			.getLogger(PortfolioApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

	@Override
	public void run(String... args) {
		LOG.info("EXECUTING : command line runner");

		for (int i = 0; i < args.length; ++i) {
			LOG.info("args[{}]: {}", i, args[i]);
		}

		User user = new User();
		user.setFullName("Full Name 1");
		user.setUsername("username1");
		user.setPassword("password1");
		userRepository.save(user);

		Album album = new Album();
		album.setCoverPhoto("Photo 1");
		album.setName("Album Name 1");
		album.setUser(user);
		albumRepository.save(album);

		album = new Album();
		album.setCoverPhoto("Photo 2");
		album.setName("Album Name 2");
		album.setUser(user);
		albumRepository.save(album);

		Photo photo = new Photo();
		photo.setAlbum(album);
		photo.setDescription("Description desc");
		photo.setName("Photo Name 1");
		photo.setUrl("URL 1");
		photoRepository.save(photo);


		Optional<User> searchedUser = userRepository.findById(Long.valueOf(1));
		searchedUser.ifPresent(user1 -> user1.getAlbumList().forEach(album1 -> {
			LOG.info(album1.getName());
			album1.getPhotoList().forEach(photo1 -> {
				LOG.info("\t-" + photo1.getName());
			});
		}));
	}

}
