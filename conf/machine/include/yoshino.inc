SOC_FAMILY = "msm8998"

require conf/machine/include/soc-family.inc
require conf/machine/include/arm/arch-armv8.inc

KERNEL_IMAGETYPE = "Image"

SERIAL_CONSOLE = "115200;ttyMSM0"

MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS += " \
  kernel-modules \
  ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'mesa-driver-msm', '', d)} \
  "

EXTRA_IMAGECMD_ext4 += " -b 4096 "

MACHINE_FEATURES = " \
  usbhost \
  usbgadget \
  alsa \
  screen \
  wifi \
  bluetooth \
  ext2 \
  "

PREFERRED_PROVIDER_u-boot ?= "u-boot"
PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot"
PREFERRED_PROVIDER_virtual/kernel ?= "linux-sony"

KERNEL_CMDLINE = "clk_ignore_unused console=ttyMSM0,115200,n8 root=/dev/block/sda65 rootwait"
KERNEL_RAMBASE = "0x80000000"
KERNEL_PAGESIZE = "4096"
RAMDISK_OFFSET = "0x02000000"
TAGS_OFFSET = "0x01E00000"

