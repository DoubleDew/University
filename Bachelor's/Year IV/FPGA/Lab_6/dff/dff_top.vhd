entity dff_top is
    Port (
        sw : in STD_LOGIC;
        btn_clr : in STD_LOGIC;
        btn_set : in STD_LOGIC;
        mclk : in STD_LOGIC;
        led_q : out STD_LOGIC;
        led_notq : out STD_LOGIC
    );
end dff_top;

architecture Behavioral of dff_top is
component dff is
    Port (
        D : in STD_LOGIC;
        clr : in STD_LOGIC;
        set : in STD_LOGIC;
        clk : in STD_LOGIC;
        q : out STD_LOGIC;
        notq : out STD_LOGIC
    );
end component;

begin
a1 : dff
    port map (
        D => sw,
        clr => btn_clr,
        set => btn_set,
        clk => mclk,
        q => led_q,
        notq => led_notq
    );

end Behavioral;