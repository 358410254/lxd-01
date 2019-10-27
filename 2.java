package com.offcn.cart.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.offcn.entity.PageResult;
import com.offcn.entity.Result;
import com.offcn.pojo.TbAddress;
import com.offcn.user.service.AddressService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/address")
public class AddressController {

	@Reference
	private AddressService addressService;

	/**
	 * ����ȫ���б�
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbAddress> findAll(){
		//�Һ���
		//222222222222222222
		return addressService.findAll();
	}


	/**
	 * ����ȫ���б�
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return addressService.findPage(page, rows);
	}

	/**
	 * ����
	 * @param address
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbAddress address){
		try {
			addressService.add(address);
			return new Result(true, "���ӳɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "����ʧ��");
		}
	}

	/**
	 * �޸�
	 * @param address
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbAddress address){
		try {
			addressService.update(address);
			return new Result(true, "�޸ĳɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "�޸�ʧ��");
		}
	}

	/**
	 * ��ȡʵ��
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbAddress findOne(Long id){
		return addressService.findOne(id);
	}

	/**
	 * ����ɾ��
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Long [] ids){
		try {
			addressService.delete(ids);
			return new Result(true, "ɾ���ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "ɾ��ʧ��");
		}
	}

		/**
	 * ��ѯ+��ҳ
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbAddress address, int page, int rows  ){
		return addressService.findPage(address, page, rows);
	}

	//�����û�id����ȡ��Ӧ��ַ����
    @RequestMapping("/findListByUserId")
    public  List<TbAddress> findListByUserId(){
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
      return addressService.findListByUserId(userId);
	}

}
