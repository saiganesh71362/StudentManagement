package com.stude.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stude.appconstants.AppConstants;
import com.stude.entity.Register;
import com.stude.globalexceptionhandle.IdNotFoundException;
import com.stude.globalexceptionhandle.NotFoundException;
import com.stude.repository.RegisterRepository;
import com.stude.service.RegisterService;

@Service
public class RepositoryServiceImpl implements RegisterService {

	@Autowired
	private RegisterRepository registerRepository;
	@Override
    public String newRegister(Register register) {
        if (register == null) {
            return AppConstants.STRING_NULL;
        }

        Integer id = register.getId();
        Register newRegister = registerRepository.save(register);

        if (newRegister != null && newRegister.getId() != null) {
            return AppConstants.RECORDCREATED_SUCCESSFULLY + newRegister.getId();
        } else {
            return AppConstants.RECORDCREATION_FAILD;
        }
    }
	@Override
	public Register getRegister(Integer id) throws Exception
	{
		Optional<Register> byId = registerRepository.findById(id);
		if(byId.isPresent())
		{
			return byId.get();
		}
		else
		{
			throw new IdNotFoundException(AppConstants.NOT_FOUND + byId);
		}
	}

	@Override
	public List<Register> getAllRegisters()
	{
		List<Register> all = registerRepository.findAll();
		return all;
	}

	@Override
	public String updateRegister(Register register, Integer id)
	{
		Register existing = registerRepository.findById(id).orElse(null);
		if(existing!=null)
		{
			existing.setFirstName(register.getFirstName());
			existing.setLastName(register.getLastName());
			existing.setContactDetails(register.getContactDetails());
			existing.setEmail(register.getEmail());
			existing.setPasswaord(register.getPasswaord());
			registerRepository.save(existing);
			
			return AppConstants.RECORD_UPDATE_SUCCESS_FULLY + id;
		}
		
		return AppConstants.RECORD_UPDATE_FAILD +id;
	}

	@Override
	public String deleteRegister(Integer id) throws Exception 
	{
		if(registerRepository.existsById(id))
		{
			registerRepository.deleteById(id);
			
			  return AppConstants.RECORD_DELETE+id;

		}
		else
		{
			 throw new NotFoundException( AppConstants.ID_NOTFOUND+id); }  // Id Not Found Exception
		}
	}


