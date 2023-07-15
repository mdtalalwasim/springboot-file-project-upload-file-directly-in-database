/*
 * package com.mdtalalwasim.fileproject.repository;
 * 
 * public interface FileRepository {
 * 
 * }
 */

package com.mdtalalwasim.fileproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdtalalwasim.fileproject.entity.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long>{
	
 Optional<File>	findByName(String fileName);

}
