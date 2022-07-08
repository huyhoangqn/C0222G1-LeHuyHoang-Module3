package model.service.contract;

import model.bean.Contract;
import model.repository.contract.ContractRepository;

import java.util.List;

public class ContractServiceImpl implements ContractService {
    ContractRepository contractRepository = new ContractRepository();

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id);
    }

    @Override
    public void add(Contract contract) {
        contractRepository.insertContract(contract);
    }

    @Override
    public void add(Contract contract, int idEmployee, int idCustomer, int idService) {
        contractRepository.insertContract(contract, idEmployee, idCustomer, idService);
    }

    @Override
    public List<Contract> getListByCustomerId(int customerId) {
        return contractRepository.getListByCustomerId(customerId);
    }


//
//    @Override
//    public void update(int id, Contract contract) {
//        contractRepository.update(id, contract);
//    }
//
//    @Override
//    public Contract remove(int id) {
//        contractRepository.remove(id);
//        return null;
//    }
//
//    @Override
//    public List<Contract> search(String name) {
//        return contractRepository.search(name);
//    }
}
