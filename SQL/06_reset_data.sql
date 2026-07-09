begin
    delete from erp_order_items;
    delete from erp_orders;
    delete from erp_products;
    delete from erp_customers;
    delete from erp_employees;
    commit;
end;
/