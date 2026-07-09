create or replace package erp_pkg as
    procedure add_employee(
        p_employee_name in varchar2,
        p_department in varchar2,
        p_salary in number
    );

    procedure add_customer(
        p_customer_name in varchar2,
        p_phone in varchar2,
        p_city in varchar2
    );

    procedure add_product(
        p_product_name in varchar2,
        p_category in varchar2,
        p_unit_price in number,
        p_stock_qty in number
    );

    function create_order(
        p_customer_id in number
    ) return number;

    procedure add_order_item(
        p_order_id in number,
        p_product_id in number,
        p_quantity in number
    );

    procedure finalize_order(
        p_order_id in number
    );
end erp_pkg;
/