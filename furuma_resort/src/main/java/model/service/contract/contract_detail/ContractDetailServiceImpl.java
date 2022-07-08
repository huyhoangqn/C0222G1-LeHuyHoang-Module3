package model.service.contract.contract_detail;

import model.bean.ContractDetail;
import model.repository.contract_detail.ContractDetailRepository;

import java.util.List;

public class ContractDetailServiceImpl implements ContractDetailService {
    ContractDetailRepository contractDetailRepository = new ContractDetailRepository();

    @Override
    public List<ContractDetail> getAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public List<ContractDetail> findByContractId(int idContract) {
        return contractDetailRepository.findByContractId(idContract);
    }

    @Override
    public void add(ContractDetail contractDetail) {
        contractDetailRepository.insertContractDetail(contractDetail);
    }

    @Override
    public void add(ContractDetail contractDetail, int idContract, int idAttach) {
        contractDetailRepository.insertContractDetail(contractDetail, idContract, idAttach);
    }
}
