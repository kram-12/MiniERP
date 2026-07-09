begin
    erp_pkg.add_employee('Kalyan', 'Admin', 45000);
    erp_pkg.add_employee('Gopi', 'Sales', 38000);
    erp_pkg.add_employee('Gigi', 'Accounts', 42000);

    erp_pkg.add_customer('Sybyl', '9876543210', 'Uganda');
    erp_pkg.add_customer('Razorpay', '9123456780', 'Bengaluru');

    erp_pkg.add_product('Laptop', 'Electronics', 55000, 10);
    erp_pkg.add_product('Printer', 'Electronics', 12000, 15);
    erp_pkg.add_product('Chair', 'Furniture', 3500, 25);

    commit;
end;
/