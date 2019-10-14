package binlist.integration.service.country;

import binlist.integration.model.Country;
import binlist.integration.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void saveCountry(Country country) {
        countryRepository.save(country);
    }
}
