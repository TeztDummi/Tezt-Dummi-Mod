package net.mcreator.teztdummimod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.teztdummimod.item.GlitchyTeztaniumPickaxeItem;
import net.mcreator.teztdummimod.TeztDummiModModVariables;
import net.mcreator.teztdummimod.TeztDummiModModElements;
import net.mcreator.teztdummimod.TeztDummiModMod;

import java.util.Map;

@TeztDummiModModElements.ModElement.Tag
public class HasteActivatorOnKeyPressedProcedure extends TeztDummiModModElements.ModElement {
	public HasteActivatorOnKeyPressedProcedure(TeztDummiModModElements instance) {
		super(instance, 150);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency entity for procedure HasteActivatorOnKeyPressed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency world for procedure HasteActivatorOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(GlitchyTeztaniumPickaxeItem.block, (int) (1)).getItem())) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent(((((TeztDummiModModVariables.MapVariables.get(world).HasteActivator) * 3.3)) + "" + ("%"))), (true));
			}
			if ((((TeztDummiModModVariables.MapVariables.get(world).HasteActivator) == 30)
					|| ((TeztDummiModModVariables.MapVariables.get(world).HasteActivator) == 0))) {
				TeztDummiModModVariables.MapVariables.get(world).HasteActivator = (double) 0;
				TeztDummiModModVariables.MapVariables.get(world).syncData(world);
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 300, (int) 20));
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;
					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						TeztDummiModModVariables.MapVariables
								.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables.get(world).HasteActivator) + 1);
						TeztDummiModModVariables.MapVariables.get(world).syncData(world);
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
									((((TeztDummiModModVariables.MapVariables.get(world).HasteActivator) * 3.3)) + "" + ("%"))), (true));
						}
						new Object() {
							private int ticks = 0;
							private float waitTicks;
							private IWorld world;
							public void start(IWorld world, int waitTicks) {
								this.waitTicks = waitTicks;
								MinecraftForge.EVENT_BUS.register(this);
								this.world = world;
							}

							@SubscribeEvent
							public void tick(TickEvent.ServerTickEvent event) {
								if (event.phase == TickEvent.Phase.END) {
									this.ticks += 1;
									if (this.ticks >= this.waitTicks)
										run();
								}
							}

							private void run() {
								TeztDummiModModVariables.MapVariables
										.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables.get(world).HasteActivator) + 1);
								TeztDummiModModVariables.MapVariables.get(world).syncData(world);
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent(
													((((TeztDummiModModVariables.MapVariables.get(world).HasteActivator) * 3.3)) + "" + ("%"))),
											(true));
								}
								new Object() {
									private int ticks = 0;
									private float waitTicks;
									private IWorld world;
									public void start(IWorld world, int waitTicks) {
										this.waitTicks = waitTicks;
										MinecraftForge.EVENT_BUS.register(this);
										this.world = world;
									}

									@SubscribeEvent
									public void tick(TickEvent.ServerTickEvent event) {
										if (event.phase == TickEvent.Phase.END) {
											this.ticks += 1;
											if (this.ticks >= this.waitTicks)
												run();
										}
									}

									private void run() {
										TeztDummiModModVariables.MapVariables.get(
												world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables.get(world).HasteActivator)
														+ 1);
										TeztDummiModModVariables.MapVariables.get(world).syncData(world);
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
													((((TeztDummiModModVariables.MapVariables.get(world).HasteActivator) * 3.3)) + "" + ("%"))),
													(true));
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private IWorld world;
											public void start(IWorld world, int waitTicks) {
												this.waitTicks = waitTicks;
												MinecraftForge.EVENT_BUS.register(this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(TickEvent.ServerTickEvent event) {
												if (event.phase == TickEvent.Phase.END) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												TeztDummiModModVariables.MapVariables
														.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																.get(world).HasteActivator) + 1);
												TeztDummiModModVariables.MapVariables.get(world).syncData(world);
												if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
													((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
															((((TeztDummiModModVariables.MapVariables.get(world).HasteActivator) * 3.3)) + ""
																	+ ("%"))),
															(true));
												}
												new Object() {
													private int ticks = 0;
													private float waitTicks;
													private IWorld world;
													public void start(IWorld world, int waitTicks) {
														this.waitTicks = waitTicks;
														MinecraftForge.EVENT_BUS.register(this);
														this.world = world;
													}

													@SubscribeEvent
													public void tick(TickEvent.ServerTickEvent event) {
														if (event.phase == TickEvent.Phase.END) {
															this.ticks += 1;
															if (this.ticks >= this.waitTicks)
																run();
														}
													}

													private void run() {
														TeztDummiModModVariables.MapVariables
																.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																		.get(world).HasteActivator) + 1);
														TeztDummiModModVariables.MapVariables.get(world).syncData(world);
														if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
															((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
																	((((TeztDummiModModVariables.MapVariables.get(world).HasteActivator) * 3.3)) + ""
																			+ ("%"))),
																	(true));
														}
														new Object() {
															private int ticks = 0;
															private float waitTicks;
															private IWorld world;
															public void start(IWorld world, int waitTicks) {
																this.waitTicks = waitTicks;
																MinecraftForge.EVENT_BUS.register(this);
																this.world = world;
															}

															@SubscribeEvent
															public void tick(TickEvent.ServerTickEvent event) {
																if (event.phase == TickEvent.Phase.END) {
																	this.ticks += 1;
																	if (this.ticks >= this.waitTicks)
																		run();
																}
															}

															private void run() {
																TeztDummiModModVariables.MapVariables
																		.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																				.get(world).HasteActivator) + 1);
																TeztDummiModModVariables.MapVariables.get(world).syncData(world);
																if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
																	((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
																			((((TeztDummiModModVariables.MapVariables.get(world).HasteActivator)
																					* 3.3)) + "" + ("%"))),
																			(true));
																}
																MinecraftForge.EVENT_BUS.unregister(this);
															}
														}.start(world, (int) 20);
														new Object() {
															private int ticks = 0;
															private float waitTicks;
															private IWorld world;
															public void start(IWorld world, int waitTicks) {
																this.waitTicks = waitTicks;
																MinecraftForge.EVENT_BUS.register(this);
																this.world = world;
															}

															@SubscribeEvent
															public void tick(TickEvent.ServerTickEvent event) {
																if (event.phase == TickEvent.Phase.END) {
																	this.ticks += 1;
																	if (this.ticks >= this.waitTicks)
																		run();
																}
															}

															private void run() {
																TeztDummiModModVariables.MapVariables
																		.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																				.get(world).HasteActivator) + 1);
																TeztDummiModModVariables.MapVariables.get(world).syncData(world);
																if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
																	((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
																			((((TeztDummiModModVariables.MapVariables.get(world).HasteActivator)
																					* 3.3)) + "" + ("%"))),
																			(true));
																}
																new Object() {
																	private int ticks = 0;
																	private float waitTicks;
																	private IWorld world;
																	public void start(IWorld world, int waitTicks) {
																		this.waitTicks = waitTicks;
																		MinecraftForge.EVENT_BUS.register(this);
																		this.world = world;
																	}

																	@SubscribeEvent
																	public void tick(TickEvent.ServerTickEvent event) {
																		if (event.phase == TickEvent.Phase.END) {
																			this.ticks += 1;
																			if (this.ticks >= this.waitTicks)
																				run();
																		}
																	}

																	private void run() {
																		TeztDummiModModVariables.MapVariables.get(
																				world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																						.get(world).HasteActivator) + 1);
																		TeztDummiModModVariables.MapVariables.get(world).syncData(world);
																		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
																			((PlayerEntity) entity).sendStatusMessage(
																					new StringTextComponent(((((TeztDummiModModVariables.MapVariables
																							.get(world).HasteActivator) * 3.3)) + "" + ("%"))),
																					(true));
																		}
																		new Object() {
																			private int ticks = 0;
																			private float waitTicks;
																			private IWorld world;
																			public void start(IWorld world, int waitTicks) {
																				this.waitTicks = waitTicks;
																				MinecraftForge.EVENT_BUS.register(this);
																				this.world = world;
																			}

																			@SubscribeEvent
																			public void tick(TickEvent.ServerTickEvent event) {
																				if (event.phase == TickEvent.Phase.END) {
																					this.ticks += 1;
																					if (this.ticks >= this.waitTicks)
																						run();
																				}
																			}

																			private void run() {
																				TeztDummiModModVariables.MapVariables.get(
																						world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																								.get(world).HasteActivator) + 1);
																				TeztDummiModModVariables.MapVariables.get(world).syncData(world);
																				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
																					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
																							((((TeztDummiModModVariables.MapVariables
																									.get(world).HasteActivator) * 3.3)) + ""
																									+ ("%"))),
																							(true));
																				}
																				new Object() {
																					private int ticks = 0;
																					private float waitTicks;
																					private IWorld world;
																					public void start(IWorld world, int waitTicks) {
																						this.waitTicks = waitTicks;
																						MinecraftForge.EVENT_BUS.register(this);
																						this.world = world;
																					}

																					@SubscribeEvent
																					public void tick(TickEvent.ServerTickEvent event) {
																						if (event.phase == TickEvent.Phase.END) {
																							this.ticks += 1;
																							if (this.ticks >= this.waitTicks)
																								run();
																						}
																					}

																					private void run() {
																						TeztDummiModModVariables.MapVariables.get(
																								world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																										.get(world).HasteActivator) + 1);
																						TeztDummiModModVariables.MapVariables.get(world)
																								.syncData(world);
																						if (entity instanceof PlayerEntity
																								&& !entity.world.isRemote()) {
																							((PlayerEntity) entity)
																									.sendStatusMessage(new StringTextComponent(
																											((((TeztDummiModModVariables.MapVariables
																													.get(world).HasteActivator)
																													* 3.3)) + "" + ("%"))),
																											(true));
																						}
																						new Object() {
																							private int ticks = 0;
																							private float waitTicks;
																							private IWorld world;
																							public void start(IWorld world, int waitTicks) {
																								this.waitTicks = waitTicks;
																								MinecraftForge.EVENT_BUS.register(this);
																								this.world = world;
																							}

																							@SubscribeEvent
																							public void tick(TickEvent.ServerTickEvent event) {
																								if (event.phase == TickEvent.Phase.END) {
																									this.ticks += 1;
																									if (this.ticks >= this.waitTicks)
																										run();
																								}
																							}

																							private void run() {
																								TeztDummiModModVariables.MapVariables.get(
																										world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																												.get(world).HasteActivator) + 1);
																								TeztDummiModModVariables.MapVariables.get(world)
																										.syncData(world);
																								if (entity instanceof PlayerEntity
																										&& !entity.world.isRemote()) {
																									((PlayerEntity) entity).sendStatusMessage(
																											new StringTextComponent(
																													((((TeztDummiModModVariables.MapVariables
																															.get(world).HasteActivator)
																															* 3.3)) + "" + ("%"))),
																											(true));
																								}
																								new Object() {
																									private int ticks = 0;
																									private float waitTicks;
																									private IWorld world;
																									public void start(IWorld world, int waitTicks) {
																										this.waitTicks = waitTicks;
																										MinecraftForge.EVENT_BUS.register(this);
																										this.world = world;
																									}

																									@SubscribeEvent
																									public void tick(
																											TickEvent.ServerTickEvent event) {
																										if (event.phase == TickEvent.Phase.END) {
																											this.ticks += 1;
																											if (this.ticks >= this.waitTicks)
																												run();
																										}
																									}

																									private void run() {
																										TeztDummiModModVariables.MapVariables.get(
																												world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																														.get(world).HasteActivator)
																														+ 1);
																										TeztDummiModModVariables.MapVariables
																												.get(world).syncData(world);
																										if (entity instanceof PlayerEntity
																												&& !entity.world.isRemote()) {
																											((PlayerEntity) entity).sendStatusMessage(
																													new StringTextComponent(
																															((((TeztDummiModModVariables.MapVariables
																																	.get(world).HasteActivator)
																																	* 3.3)) + ""
																																	+ ("%"))),
																													(true));
																										}
																										new Object() {
																											private int ticks = 0;
																											private float waitTicks;
																											private IWorld world;
																											public void start(IWorld world,
																													int waitTicks) {
																												this.waitTicks = waitTicks;
																												MinecraftForge.EVENT_BUS
																														.register(this);
																												this.world = world;
																											}

																											@SubscribeEvent
																											public void tick(
																													TickEvent.ServerTickEvent event) {
																												if (event.phase == TickEvent.Phase.END) {
																													this.ticks += 1;
																													if (this.ticks >= this.waitTicks)
																														run();
																												}
																											}

																											private void run() {
																												TeztDummiModModVariables.MapVariables
																														.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																																.get(world).HasteActivator)
																																+ 1);
																												TeztDummiModModVariables.MapVariables
																														.get(world).syncData(world);
																												if (entity instanceof PlayerEntity
																														&& !entity.world.isRemote()) {
																													((PlayerEntity) entity)
																															.sendStatusMessage(
																																	new StringTextComponent(
																																			((((TeztDummiModModVariables.MapVariables
																																					.get(world).HasteActivator)
																																					* 3.3))
																																					+ ""
																																					+ ("%"))),
																																	(true));
																												}
																												new Object() {
																													private int ticks = 0;
																													private float waitTicks;
																													private IWorld world;
																													public void start(IWorld world,
																															int waitTicks) {
																														this.waitTicks = waitTicks;
																														MinecraftForge.EVENT_BUS
																																.register(this);
																														this.world = world;
																													}

																													@SubscribeEvent
																													public void tick(
																															TickEvent.ServerTickEvent event) {
																														if (event.phase == TickEvent.Phase.END) {
																															this.ticks += 1;
																															if (this.ticks >= this.waitTicks)
																																run();
																														}
																													}

																													private void run() {
																														TeztDummiModModVariables.MapVariables
																																.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																																		.get(world).HasteActivator)
																																		+ 1);
																														TeztDummiModModVariables.MapVariables
																																.get(world)
																																.syncData(world);
																														if (entity instanceof PlayerEntity
																																&& !entity.world
																																		.isRemote()) {
																															((PlayerEntity) entity)
																																	.sendStatusMessage(
																																			new StringTextComponent(
																																					((((TeztDummiModModVariables.MapVariables
																																							.get(world).HasteActivator)
																																							* 3.3))
																																							+ ""
																																							+ ("%"))),
																																			(true));
																														}
																														new Object() {
																															private int ticks = 0;
																															private float waitTicks;
																															private IWorld world;
																															public void start(
																																	IWorld world,
																																	int waitTicks) {
																																this.waitTicks = waitTicks;
																																MinecraftForge.EVENT_BUS
																																		.register(
																																				this);
																																this.world = world;
																															}

																															@SubscribeEvent
																															public void tick(
																																	TickEvent.ServerTickEvent event) {
																																if (event.phase == TickEvent.Phase.END) {
																																	this.ticks += 1;
																																	if (this.ticks >= this.waitTicks)
																																		run();
																																}
																															}

																															private void run() {
																																TeztDummiModModVariables.MapVariables
																																		.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																																				.get(world).HasteActivator)
																																				+ 1);
																																TeztDummiModModVariables.MapVariables
																																		.get(world)
																																		.syncData(
																																				world);
																																if (entity instanceof PlayerEntity
																																		&& !entity.world
																																				.isRemote()) {
																																	((PlayerEntity) entity)
																																			.sendStatusMessage(
																																					new StringTextComponent(
																																							((((TeztDummiModModVariables.MapVariables
																																									.get(world).HasteActivator)
																																									* 3.3))
																																									+ ""
																																									+ ("%"))),
																																					(true));
																																}
																																new Object() {
																																	private int ticks = 0;
																																	private float waitTicks;
																																	private IWorld world;
																																	public void start(
																																			IWorld world,
																																			int waitTicks) {
																																		this.waitTicks = waitTicks;
																																		MinecraftForge.EVENT_BUS
																																				.register(
																																						this);
																																		this.world = world;
																																	}

																																	@SubscribeEvent
																																	public void tick(
																																			TickEvent.ServerTickEvent event) {
																																		if (event.phase == TickEvent.Phase.END) {
																																			this.ticks += 1;
																																			if (this.ticks >= this.waitTicks)
																																				run();
																																		}
																																	}

																																	private void run() {
																																		TeztDummiModModVariables.MapVariables
																																				.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																																						.get(world).HasteActivator)
																																						+ 1);
																																		TeztDummiModModVariables.MapVariables
																																				.get(world)
																																				.syncData(
																																						world);
																																		if (entity instanceof PlayerEntity
																																				&& !entity.world
																																						.isRemote()) {
																																			((PlayerEntity) entity)
																																					.sendStatusMessage(
																																							new StringTextComponent(
																																									((((TeztDummiModModVariables.MapVariables
																																											.get(world).HasteActivator)
																																											* 3.3))
																																											+ ""
																																											+ ("%"))),
																																							(true));
																																		}
																																		new Object() {
																																			private int ticks = 0;
																																			private float waitTicks;
																																			private IWorld world;
																																			public void start(
																																					IWorld world,
																																					int waitTicks) {
																																				this.waitTicks = waitTicks;
																																				MinecraftForge.EVENT_BUS
																																						.register(
																																								this);
																																				this.world = world;
																																			}

																																			@SubscribeEvent
																																			public void tick(
																																					TickEvent.ServerTickEvent event) {
																																				if (event.phase == TickEvent.Phase.END) {
																																					this.ticks += 1;
																																					if (this.ticks >= this.waitTicks)
																																						run();
																																				}
																																			}

																																			private void run() {
																																				TeztDummiModModVariables.MapVariables
																																						.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																																								.get(world).HasteActivator)
																																								+ 1);
																																				TeztDummiModModVariables.MapVariables
																																						.get(world)
																																						.syncData(
																																								world);
																																				if (entity instanceof PlayerEntity
																																						&& !entity.world
																																								.isRemote()) {
																																					((PlayerEntity) entity)
																																							.sendStatusMessage(
																																									new StringTextComponent(
																																											((((TeztDummiModModVariables.MapVariables
																																													.get(world).HasteActivator)
																																													* 3.3))
																																													+ ""
																																													+ ("%"))),
																																									(true));
																																				}
																																				new Object() {
																																					private int ticks = 0;
																																					private float waitTicks;
																																					private IWorld world;
																																					public void start(
																																							IWorld world,
																																							int waitTicks) {
																																						this.waitTicks = waitTicks;
																																						MinecraftForge.EVENT_BUS
																																								.register(
																																										this);
																																						this.world = world;
																																					}

																																					@SubscribeEvent
																																					public void tick(
																																							TickEvent.ServerTickEvent event) {
																																						if (event.phase == TickEvent.Phase.END) {
																																							this.ticks += 1;
																																							if (this.ticks >= this.waitTicks)
																																								run();
																																						}
																																					}

																																					private void run() {
																																						TeztDummiModModVariables.MapVariables
																																								.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																																										.get(world).HasteActivator)
																																										+ 1);
																																						TeztDummiModModVariables.MapVariables
																																								.get(world)
																																								.syncData(
																																										world);
																																						if (entity instanceof PlayerEntity
																																								&& !entity.world
																																										.isRemote()) {
																																							((PlayerEntity) entity)
																																									.sendStatusMessage(
																																											new StringTextComponent(
																																													((((TeztDummiModModVariables.MapVariables
																																															.get(world).HasteActivator)
																																															* 3.3))
																																															+ ""
																																															+ ("%"))),
																																											(true));
																																						}
																																						new Object() {
																																							private int ticks = 0;
																																							private float waitTicks;
																																							private IWorld world;
																																							public void start(
																																									IWorld world,
																																									int waitTicks) {
																																								this.waitTicks = waitTicks;
																																								MinecraftForge.EVENT_BUS
																																										.register(
																																												this);
																																								this.world = world;
																																							}

																																							@SubscribeEvent
																																							public void tick(
																																									TickEvent.ServerTickEvent event) {
																																								if (event.phase == TickEvent.Phase.END) {
																																									this.ticks += 1;
																																									if (this.ticks >= this.waitTicks)
																																										run();
																																								}
																																							}

																																							private void run() {
																																								TeztDummiModModVariables.MapVariables
																																										.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																																												.get(world).HasteActivator)
																																												+ 1);
																																								TeztDummiModModVariables.MapVariables
																																										.get(world)
																																										.syncData(
																																												world);
																																								if (entity instanceof PlayerEntity
																																										&& !entity.world
																																												.isRemote()) {
																																									((PlayerEntity) entity)
																																											.sendStatusMessage(
																																													new StringTextComponent(
																																															((((TeztDummiModModVariables.MapVariables
																																																	.get(world).HasteActivator)
																																																	* 3.3))
																																																	+ ""
																																																	+ ("%"))),
																																													(true));
																																								}
																																								new Object() {
																																									private int ticks = 0;
																																									private float waitTicks;
																																									private IWorld world;
																																									public void start(
																																											IWorld world,
																																											int waitTicks) {
																																										this.waitTicks = waitTicks;
																																										MinecraftForge.EVENT_BUS
																																												.register(
																																														this);
																																										this.world = world;
																																									}

																																									@SubscribeEvent
																																									public void tick(
																																											TickEvent.ServerTickEvent event) {
																																										if (event.phase == TickEvent.Phase.END) {
																																											this.ticks += 1;
																																											if (this.ticks >= this.waitTicks)
																																												run();
																																										}
																																									}

																																									private void run() {
																																										TeztDummiModModVariables.MapVariables
																																												.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																																														.get(world).HasteActivator)
																																														+ 1);
																																										TeztDummiModModVariables.MapVariables
																																												.get(world)
																																												.syncData(
																																														world);
																																										if (entity instanceof PlayerEntity
																																												&& !entity.world
																																														.isRemote()) {
																																											((PlayerEntity) entity)
																																													.sendStatusMessage(
																																															new StringTextComponent(
																																																	((((TeztDummiModModVariables.MapVariables
																																																			.get(world).HasteActivator)
																																																			* 3.3))
																																																			+ ""
																																																			+ ("%"))),
																																															(true));
																																										}
																																										new Object() {
																																											private int ticks = 0;
																																											private float waitTicks;
																																											private IWorld world;
																																											public void start(
																																													IWorld world,
																																													int waitTicks) {
																																												this.waitTicks = waitTicks;
																																												MinecraftForge.EVENT_BUS
																																														.register(
																																																this);
																																												this.world = world;
																																											}

																																											@SubscribeEvent
																																											public void tick(
																																													TickEvent.ServerTickEvent event) {
																																												if (event.phase == TickEvent.Phase.END) {
																																													this.ticks += 1;
																																													if (this.ticks >= this.waitTicks)
																																														run();
																																												}
																																											}

																																											private void run() {
																																												TeztDummiModModVariables.MapVariables
																																														.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																																																.get(world).HasteActivator)
																																																+ 1);
																																												TeztDummiModModVariables.MapVariables
																																														.get(world)
																																														.syncData(
																																																world);
																																												if (entity instanceof PlayerEntity
																																														&& !entity.world
																																																.isRemote()) {
																																													((PlayerEntity) entity)
																																															.sendStatusMessage(
																																																	new StringTextComponent(
																																																			((((TeztDummiModModVariables.MapVariables
																																																					.get(world).HasteActivator)
																																																					* 3.3))
																																																					+ ""
																																																					+ ("%"))),
																																																	(true));
																																												}
																																												new Object() {
																																													private int ticks = 0;
																																													private float waitTicks;
																																													private IWorld world;
																																													public void start(
																																															IWorld world,
																																															int waitTicks) {
																																														this.waitTicks = waitTicks;
																																														MinecraftForge.EVENT_BUS
																																																.register(
																																																		this);
																																														this.world = world;
																																													}

																																													@SubscribeEvent
																																													public void tick(
																																															TickEvent.ServerTickEvent event) {
																																														if (event.phase == TickEvent.Phase.END) {
																																															this.ticks += 1;
																																															if (this.ticks >= this.waitTicks)
																																																run();
																																														}
																																													}

																																													private void run() {
																																														TeztDummiModModVariables.MapVariables
																																																.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																																																		.get(world).HasteActivator)
																																																		+ 1);
																																														TeztDummiModModVariables.MapVariables
																																																.get(world)
																																																.syncData(
																																																		world);
																																														if (entity instanceof PlayerEntity
																																																&& !entity.world
																																																		.isRemote()) {
																																															((PlayerEntity) entity)
																																																	.sendStatusMessage(
																																																			new StringTextComponent(
																																																					((((TeztDummiModModVariables.MapVariables
																																																							.get(world).HasteActivator)
																																																							* 3.3))
																																																							+ ""
																																																							+ ("%"))),
																																																			(true));
																																														}
																																														new Object() {
																																															private int ticks = 0;
																																															private float waitTicks;
																																															private IWorld world;
																																															public void start(
																																																	IWorld world,
																																																	int waitTicks) {
																																																this.waitTicks = waitTicks;
																																																MinecraftForge.EVENT_BUS
																																																		.register(
																																																				this);
																																																this.world = world;
																																															}

																																															@SubscribeEvent
																																															public void tick(
																																																	TickEvent.ServerTickEvent event) {
																																																if (event.phase == TickEvent.Phase.END) {
																																																	this.ticks += 1;
																																																	if (this.ticks >= this.waitTicks)
																																																		run();
																																																}
																																															}

																																															private void run() {
																																																TeztDummiModModVariables.MapVariables
																																																		.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																																																				.get(world).HasteActivator)
																																																				+ 1);
																																																TeztDummiModModVariables.MapVariables
																																																		.get(world)
																																																		.syncData(
																																																				world);
																																																if (entity instanceof PlayerEntity
																																																		&& !entity.world
																																																				.isRemote()) {
																																																	((PlayerEntity) entity)
																																																			.sendStatusMessage(
																																																					new StringTextComponent(
																																																							((((TeztDummiModModVariables.MapVariables
																																																									.get(world).HasteActivator)
																																																									* 3.3))
																																																									+ ""
																																																									+ ("%"))),
																																																					(true));
																																																}
																																																new Object() {
																																																	private int ticks = 0;
																																																	private float waitTicks;
																																																	private IWorld world;
																																																	public void start(
																																																			IWorld world,
																																																			int waitTicks) {
																																																		this.waitTicks = waitTicks;
																																																		MinecraftForge.EVENT_BUS
																																																				.register(
																																																						this);
																																																		this.world = world;
																																																	}

																																																	@SubscribeEvent
																																																	public void tick(
																																																			TickEvent.ServerTickEvent event) {
																																																		if (event.phase == TickEvent.Phase.END) {
																																																			this.ticks += 1;
																																																			if (this.ticks >= this.waitTicks)
																																																				run();
																																																		}
																																																	}

																																																	private void run() {
																																																		TeztDummiModModVariables.MapVariables
																																																				.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																																																						.get(world).HasteActivator)
																																																						+ 1);
																																																		TeztDummiModModVariables.MapVariables
																																																				.get(world)
																																																				.syncData(
																																																						world);
																																																		if (entity instanceof PlayerEntity
																																																				&& !entity.world
																																																						.isRemote()) {
																																																			((PlayerEntity) entity)
																																																					.sendStatusMessage(
																																																							new StringTextComponent(
																																																									((((TeztDummiModModVariables.MapVariables
																																																											.get(world).HasteActivator)
																																																											* 3.3))
																																																											+ ""
																																																											+ ("%"))),
																																																							(true));
																																																		}
																																																		new Object() {
																																																			private int ticks = 0;
																																																			private float waitTicks;
																																																			private IWorld world;
																																																			public void start(
																																																					IWorld world,
																																																					int waitTicks) {
																																																				this.waitTicks = waitTicks;
																																																				MinecraftForge.EVENT_BUS
																																																						.register(
																																																								this);
																																																				this.world = world;
																																																			}

																																																			@SubscribeEvent
																																																			public void tick(
																																																					TickEvent.ServerTickEvent event) {
																																																				if (event.phase == TickEvent.Phase.END) {
																																																					this.ticks += 1;
																																																					if (this.ticks >= this.waitTicks)
																																																						run();
																																																				}
																																																			}

																																																			private void run() {
																																																				TeztDummiModModVariables.MapVariables
																																																						.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																																																								.get(world).HasteActivator)
																																																								+ 1);
																																																				TeztDummiModModVariables.MapVariables
																																																						.get(world)
																																																						.syncData(
																																																								world);
																																																				if (entity instanceof PlayerEntity
																																																						&& !entity.world
																																																								.isRemote()) {
																																																					((PlayerEntity) entity)
																																																							.sendStatusMessage(
																																																									new StringTextComponent(
																																																											((((TeztDummiModModVariables.MapVariables
																																																													.get(world).HasteActivator)
																																																													* 3.3))
																																																													+ ""
																																																													+ ("%"))),
																																																									(true));
																																																				}
																																																				new Object() {
																																																					private int ticks = 0;
																																																					private float waitTicks;
																																																					private IWorld world;
																																																					public void start(
																																																							IWorld world,
																																																							int waitTicks) {
																																																						this.waitTicks = waitTicks;
																																																						MinecraftForge.EVENT_BUS
																																																								.register(
																																																										this);
																																																						this.world = world;
																																																					}

																																																					@SubscribeEvent
																																																					public void tick(
																																																							TickEvent.ServerTickEvent event) {
																																																						if (event.phase == TickEvent.Phase.END) {
																																																							this.ticks += 1;
																																																							if (this.ticks >= this.waitTicks)
																																																								run();
																																																						}
																																																					}

																																																					private void run() {
																																																						TeztDummiModModVariables.MapVariables
																																																								.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																																																										.get(world).HasteActivator)
																																																										+ 1);
																																																						TeztDummiModModVariables.MapVariables
																																																								.get(world)
																																																								.syncData(
																																																										world);
																																																						if (entity instanceof PlayerEntity
																																																								&& !entity.world
																																																										.isRemote()) {
																																																							((PlayerEntity) entity)
																																																									.sendStatusMessage(
																																																											new StringTextComponent(
																																																													((((TeztDummiModModVariables.MapVariables
																																																															.get(world).HasteActivator)
																																																															* 3.3))
																																																															+ ""
																																																															+ ("%"))),
																																																											(true));
																																																						}
																																																						new Object() {
																																																							private int ticks = 0;
																																																							private float waitTicks;
																																																							private IWorld world;
																																																							public void start(
																																																									IWorld world,
																																																									int waitTicks) {
																																																								this.waitTicks = waitTicks;
																																																								MinecraftForge.EVENT_BUS
																																																										.register(
																																																												this);
																																																								this.world = world;
																																																							}

																																																							@SubscribeEvent
																																																							public void tick(
																																																									TickEvent.ServerTickEvent event) {
																																																								if (event.phase == TickEvent.Phase.END) {
																																																									this.ticks += 1;
																																																									if (this.ticks >= this.waitTicks)
																																																										run();
																																																								}
																																																							}

																																																							private void run() {
																																																								TeztDummiModModVariables.MapVariables
																																																										.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																																																												.get(world).HasteActivator)
																																																												+ 1);
																																																								TeztDummiModModVariables.MapVariables
																																																										.get(world)
																																																										.syncData(
																																																												world);
																																																								if (entity instanceof PlayerEntity
																																																										&& !entity.world
																																																												.isRemote()) {
																																																									((PlayerEntity) entity)
																																																											.sendStatusMessage(
																																																													new StringTextComponent(
																																																															((((TeztDummiModModVariables.MapVariables
																																																																	.get(world).HasteActivator)
																																																																	* 3.3))
																																																																	+ ""
																																																																	+ ("%"))),
																																																													(true));
																																																								}
																																																								new Object() {
																																																									private int ticks = 0;
																																																									private float waitTicks;
																																																									private IWorld world;
																																																									public void start(
																																																											IWorld world,
																																																											int waitTicks) {
																																																										this.waitTicks = waitTicks;
																																																										MinecraftForge.EVENT_BUS
																																																												.register(
																																																														this);
																																																										this.world = world;
																																																									}

																																																									@SubscribeEvent
																																																									public void tick(
																																																											TickEvent.ServerTickEvent event) {
																																																										if (event.phase == TickEvent.Phase.END) {
																																																											this.ticks += 1;
																																																											if (this.ticks >= this.waitTicks)
																																																												run();
																																																										}
																																																									}

																																																									private void run() {
																																																										TeztDummiModModVariables.MapVariables
																																																												.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																																																														.get(world).HasteActivator)
																																																														+ 1);
																																																										TeztDummiModModVariables.MapVariables
																																																												.get(world)
																																																												.syncData(
																																																														world);
																																																										if (entity instanceof PlayerEntity
																																																												&& !entity.world
																																																														.isRemote()) {
																																																											((PlayerEntity) entity)
																																																													.sendStatusMessage(
																																																															new StringTextComponent(
																																																																	((((TeztDummiModModVariables.MapVariables
																																																																			.get(world).HasteActivator)
																																																																			* 3.3))
																																																																			+ ""
																																																																			+ ("%"))),
																																																															(true));
																																																										}
																																																										new Object() {
																																																											private int ticks = 0;
																																																											private float waitTicks;
																																																											private IWorld world;
																																																											public void start(
																																																													IWorld world,
																																																													int waitTicks) {
																																																												this.waitTicks = waitTicks;
																																																												MinecraftForge.EVENT_BUS
																																																														.register(
																																																																this);
																																																												this.world = world;
																																																											}

																																																											@SubscribeEvent
																																																											public void tick(
																																																													TickEvent.ServerTickEvent event) {
																																																												if (event.phase == TickEvent.Phase.END) {
																																																													this.ticks += 1;
																																																													if (this.ticks >= this.waitTicks)
																																																														run();
																																																												}
																																																											}

																																																											private void run() {
																																																												TeztDummiModModVariables.MapVariables
																																																														.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																																																																.get(world).HasteActivator)
																																																																+ 1);
																																																												TeztDummiModModVariables.MapVariables
																																																														.get(world)
																																																														.syncData(
																																																																world);
																																																												if (entity instanceof PlayerEntity
																																																														&& !entity.world
																																																																.isRemote()) {
																																																													((PlayerEntity) entity)
																																																															.sendStatusMessage(
																																																																	new StringTextComponent(
																																																																			((((TeztDummiModModVariables.MapVariables
																																																																					.get(world).HasteActivator)
																																																																					* 3.3))
																																																																					+ ""
																																																																					+ ("%"))),
																																																																	(true));
																																																												}
																																																												new Object() {
																																																													private int ticks = 0;
																																																													private float waitTicks;
																																																													private IWorld world;
																																																													public void start(
																																																															IWorld world,
																																																															int waitTicks) {
																																																														this.waitTicks = waitTicks;
																																																														MinecraftForge.EVENT_BUS
																																																																.register(
																																																																		this);
																																																														this.world = world;
																																																													}

																																																													@SubscribeEvent
																																																													public void tick(
																																																															TickEvent.ServerTickEvent event) {
																																																														if (event.phase == TickEvent.Phase.END) {
																																																															this.ticks += 1;
																																																															if (this.ticks >= this.waitTicks)
																																																																run();
																																																														}
																																																													}

																																																													private void run() {
																																																														TeztDummiModModVariables.MapVariables
																																																																.get(world).HasteActivator = (double) ((TeztDummiModModVariables.MapVariables
																																																																		.get(world).HasteActivator)
																																																																		+ 1);
																																																														TeztDummiModModVariables.MapVariables
																																																																.get(world)
																																																																.syncData(
																																																																		world);
																																																														if (entity instanceof PlayerEntity
																																																																&& !entity.world
																																																																		.isRemote()) {
																																																															((PlayerEntity) entity)
																																																																	.sendStatusMessage(
																																																																			new StringTextComponent(
																																																																					((((TeztDummiModModVariables.MapVariables
																																																																							.get(world).HasteActivator)
																																																																							* 3.3))
																																																																							+ ""
																																																																							+ ("%"))),
																																																																			(true));
																																																														}
																																																														new Object() {
																																																															private int ticks = 0;
																																																															private float waitTicks;
																																																															private IWorld world;
																																																															public void start(
																																																																	IWorld world,
																																																																	int waitTicks) {
																																																																this.waitTicks = waitTicks;
																																																																MinecraftForge.EVENT_BUS
																																																																		.register(
																																																																				this);
																																																																this.world = world;
																																																															}

																																																															@SubscribeEvent
																																																															public void tick(
																																																																	TickEvent.ServerTickEvent event) {
																																																																if (event.phase == TickEvent.Phase.END) {
																																																																	this.ticks += 1;
																																																																	if (this.ticks >= this.waitTicks)
																																																																		run();
																																																																}
																																																															}

																																																															private void run() {
																																																																if (entity instanceof PlayerEntity
																																																																		&& !entity.world
																																																																				.isRemote()) {
																																																																	((PlayerEntity) entity)
																																																																			.sendStatusMessage(
																																																																					new StringTextComponent(
																																																																							"100%"),
																																																																					(true));
																																																																}
																																																																MinecraftForge.EVENT_BUS
																																																																		.unregister(
																																																																				this);
																																																															}
																																																														}.start(world,
																																																																(int) 20);
																																																														MinecraftForge.EVENT_BUS
																																																																.unregister(
																																																																		this);
																																																													}
																																																												}.start(world,
																																																														(int) 20);
																																																												MinecraftForge.EVENT_BUS
																																																														.unregister(
																																																																this);
																																																											}
																																																										}.start(world,
																																																												(int) 20);
																																																										MinecraftForge.EVENT_BUS
																																																												.unregister(
																																																														this);
																																																									}
																																																								}.start(world,
																																																										(int) 20);
																																																								MinecraftForge.EVENT_BUS
																																																										.unregister(
																																																												this);
																																																							}
																																																						}.start(world,
																																																								(int) 20);
																																																						MinecraftForge.EVENT_BUS
																																																								.unregister(
																																																										this);
																																																					}
																																																				}.start(world,
																																																						(int) 20);
																																																				MinecraftForge.EVENT_BUS
																																																						.unregister(
																																																								this);
																																																			}
																																																		}.start(world,
																																																				(int) 20);
																																																		MinecraftForge.EVENT_BUS
																																																				.unregister(
																																																						this);
																																																	}
																																																}.start(world,
																																																		(int) 20);
																																																MinecraftForge.EVENT_BUS
																																																		.unregister(
																																																				this);
																																															}
																																														}.start(world,
																																																(int) 20);
																																														MinecraftForge.EVENT_BUS
																																																.unregister(
																																																		this);
																																													}
																																												}.start(world,
																																														(int) 20);
																																												MinecraftForge.EVENT_BUS
																																														.unregister(
																																																this);
																																											}
																																										}.start(world,
																																												(int) 20);
																																										MinecraftForge.EVENT_BUS
																																												.unregister(
																																														this);
																																									}
																																								}.start(world,
																																										(int) 20);
																																								MinecraftForge.EVENT_BUS
																																										.unregister(
																																												this);
																																							}
																																						}.start(world,
																																								(int) 20);
																																						MinecraftForge.EVENT_BUS
																																								.unregister(
																																										this);
																																					}
																																				}.start(world,
																																						(int) 20);
																																				MinecraftForge.EVENT_BUS
																																						.unregister(
																																								this);
																																			}
																																		}.start(world,
																																				(int) 20);
																																		MinecraftForge.EVENT_BUS
																																				.unregister(
																																						this);
																																	}
																																}.start(world,
																																		(int) 20);
																																MinecraftForge.EVENT_BUS
																																		.unregister(
																																				this);
																															}
																														}.start(world, (int) 20);
																														MinecraftForge.EVENT_BUS
																																.unregister(this);
																													}
																												}.start(world, (int) 20);
																												MinecraftForge.EVENT_BUS
																														.unregister(this);
																											}
																										}.start(world, (int) 20);
																										MinecraftForge.EVENT_BUS.unregister(this);
																									}
																								}.start(world, (int) 20);
																								MinecraftForge.EVENT_BUS.unregister(this);
																							}
																						}.start(world, (int) 20);
																						MinecraftForge.EVENT_BUS.unregister(this);
																					}
																				}.start(world, (int) 20);
																				MinecraftForge.EVENT_BUS.unregister(this);
																			}
																		}.start(world, (int) 20);
																		MinecraftForge.EVENT_BUS.unregister(this);
																	}
																}.start(world, (int) 20);
																MinecraftForge.EVENT_BUS.unregister(this);
															}
														}.start(world, (int) 20);
														MinecraftForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 20);
												MinecraftForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 20);
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 20);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 20);
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 300);
			}
		}
	}
}
