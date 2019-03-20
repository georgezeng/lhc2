package net.geozen.lhc2.jpa.fd;

import java.util.List;

import net.geozen.lhc2.def.jpa.BaseSwRepository;
import net.geozen.lhc2.domain.fd.Fdsw;

public interface FdswRepository extends BaseSwRepository<Fdsw> {
	List<Fdsw> findAllByPhaseLessThanEqual(int phase);
}
