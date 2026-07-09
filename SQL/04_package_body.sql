create or replace package body erp_pkg as
    procedure add_employee(
        p_employee_name in varchar2,
        p_department in varchar2,
        p_salary in number
    ) is
    begin
        insert into erp_employees(employee_name, department, salary)
        values (p_employee_name, p_department, p_salary);
    end;

    procedure add_customer(
        p_customer_name in varchar2,
        p_phone in varchar2,
        p_city in varchar2
    ) is
    begin
        insert into erp_customers(customer_name, phone, city)
        values (p_customer_name, p_phone, p_city);
    end;

    procedure add_product(
        p_product_name in varchar2,
        p_category in varchar2,
        p_unit_price in number,
        p_stock_qty in number
    ) is
    begin
        insert into erp_products(product_name, category, unit_price, stock_qty)
        values (p_product_name, p_category, p_unit_price, p_stock_qty);
    end;

    function create_order(
        p_customer_id in number
    ) return number is
        v_order_id number;
    begin
        insert into erp_orders(customer_id, status)
        values (p_customer_id, 'CREATED')
        returning order_id into v_order_id;

        return v_order_id;
    end;

    procedure add_order_item(
        p_order_id in number,
        p_product_id in number,
        p_quantity in number
    ) is
        v_unit_price erp_products.unit_price%type;
        v_stock_qty erp_products.stock_qty%type;
    begin
        select unit_price, stock_qty
        into v_unit_price, v_stock_qty
        from erp_products
        where product_id = p_product_id;

        if v_stock_qty < p_quantity then
            raise_application_error(-20001, 'Insufficient stock for product ' || p_product_id);
        end if;

        insert into erp_order_items(order_id, product_id, quantity, unit_price, line_total)
        values (p_order_id, p_product_id, p_quantity, v_unit_price, p_quantity * v_unit_price);

        update erp_products
        set stock_qty = stock_qty - p_quantity
        where product_id = p_product_id;
    end;

    procedure finalize_order(
        p_order_id in number
    ) is
    begin
        update erp_orders
        set status = 'CONFIRMED'
        where order_id = p_order_id;
    end;
end erp_pkg;
/