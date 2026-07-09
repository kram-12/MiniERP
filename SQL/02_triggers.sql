create or replace trigger trg_erp_order_items_line_total
before insert or update on erp_order_items
for each row
begin
    :new.line_total := :new.quantity * :new.unit_price;
end;
/